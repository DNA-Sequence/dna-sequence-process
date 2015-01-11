package br.com.samuelklein.dna.formula;

import java.util.ArrayList;
import java.util.List;

import br.com.samuelklein.dna.bean.DataRetorn;
import br.com.samuelklein.dna.bean.InputAlign;
import br.com.samuelklein.dna.bean.InputAlignGlobalLocal;
import br.com.samuelklein.dna.bean.InputResultAlign;
import br.com.samuelklein.dna.bean.Matrix;
import br.com.samuelklein.dna.bean.Node;
import br.com.samuelklein.dna.bean.OutputAlign;
import br.com.samuelklein.dna.bean.OutputResultAlign;
import br.com.samuelklein.dna.bean.enums.Connected;

public abstract class AbstractCalculation implements Calculation {

	protected OutputAlign outputAlign;
	protected OutputResultAlign outputResultAlign;

	protected InputResultAlign inputResultAlign;
	protected InputAlign inputAlign;

	protected OrganizeNode organizeNode;

	protected int gap;
	protected int match;
	protected int misMatch;

	public AbstractCalculation(InputAlign inputAlign) {
		super();
		this.inputAlign = inputAlign;
	}

	@Override
	public void calculationNode() {
		outputAlign = new OutputAlign();
		List<Matrix> list = new ArrayList<Matrix>();
		Matrix matrix = createMatriz();
		list.add(matrix);
		executeOrganizeNode(matrix);
		outputAlign.setMatrixs(list);
	}

	private void executeOrganizeNode(Matrix matrix) {
		organizeNode = new OrganizeNode(matrix);
		organizeNode.setSequenceA(inputAlign.getSequenceA());
		organizeNode.setSequenceB(inputAlign.getSequenceB());

		organizeNode.organize();
	}

	@Override
	public void findAligns() {
	}

	@Override
	public void findAlign() {
		List<Node> listNode = new ArrayList<Node>();
		List<Connected> listConnecteds = inputResultAlign.getConnecteds();
		outputResultAlign = new OutputResultAlign();

		NodeController nodeController = null;
		if (inputResultAlign.getNode() != null) {
			organizeNode.getControllers().get(inputResultAlign.getNode());
		} else {
			Node[][] nodes = outputAlign.getMatrixs().get(0).getNodes();
			nodeController = organizeNode.getControllers().get(nodes[nodes.length - 1][nodes[0].length - 1]);
		}

		Sequence sequence = new Sequence();
		listNode.add(nodeController.getNode());
		findAlignNode(listNode, nodeController, listConnecteds, sequence);

		System.out.println(sequence.sbSeqA);
		System.out.println(sequence.sbSeqB);

		outputResultAlign.setNodes(listNode);

		outputResultAlign.setResultSequenceA(sequence.sbSeqA.toString());
		outputResultAlign.setResultSequenceB(sequence.sbSeqB.toString());
		outputResultAlign.setScore(sequence.score);

	}

	protected Matrix createMatriz() {
		Matrix matrix = new Matrix();

		String[] arrayA = inputAlign.getSequenceA().split("(?!^)");
		String[] arrayB = inputAlign.getSequenceB().split("(?!^)");

		Node[][] nodes = new Node[arrayA.length + 1][arrayB.length + 1];

		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes[i].length; j++) {
				Node n = new Node();
				n.setX(i);
				n.setY(j);
				try {
					n.setCharSeqA(arrayA[i - 1]);
				} catch (Exception e) {
					n.setCharSeqA(" ");
				}

				try {
					n.setCharSeqB(arrayB[j - 1]);
				} catch (Exception e) {
					n.setCharSeqB(" ");
				}

				nodes[i][j] = n;
			}
		}

		matrix.setNodes(nodes);
		matrix.setSequenceA(arrayA);
		matrix.setSequenceB(arrayB);

		return matrix;
	}

	public int getInt(Integer integer) {
		if (integer == null) {
			return 0;
		}

		return integer.intValue();
	}

	public boolean getBoolean(Boolean boo) {
		if (boo == null) {
			return false;
		}

		return boo.booleanValue();
	}

	protected void setGaps() {
		if (inputAlign instanceof InputAlignGlobalLocal) {
			InputAlignGlobalLocal inputAlignGlobalLocal = (InputAlignGlobalLocal) inputAlign;
			gap = inputAlignGlobalLocal.getGap();
			match = inputAlignGlobalLocal.getMatch();
			misMatch = inputAlignGlobalLocal.getMisMatch();
		} else {
			gap = -1;
			match = 2;
			misMatch = -2;
		}
	}

	protected NodeController findAlignsNode(NodeController nodeController) {
		Node node = nodeController.getNode();
		if (!getBoolean(node.getCandidate())) {
			node.setCandidate(true);
			NodeController nextNode = null;
			nextNode = align(nodeController, Connected.W);
			if (nextNode != null) {
				findAlignsNode(nextNode);
			}
			nextNode = align(nodeController, Connected.N);
			if (nextNode != null) {
				findAlignsNode(nextNode);
			}
			nextNode = align(nodeController, Connected.NW);
			if (nextNode != null) {
				findAlignsNode(nextNode);
			}
			return nextNode;
		}

		return null;
	}

	protected void findAlignNode(List<Node> listNode, NodeController nodeController, List<Connected> listConnecteds, Sequence sequence) {
		Node node = nodeController.getNode();
		if (getBoolean(node.getCandidate())) {
			NodeController nextNode = null;

			for (Connected connected : listConnecteds) {
				nextNode = align(nodeController, connected);
				if (nextNode != null) {

					if (connected == Connected.W) {
						sequence.sbSeqA.insert(0, node.getCharSeqA());
						sequence.sbSeqB.insert(0, "_");
						sequence.score = sequence.score + gap;
					} else if (connected == Connected.N) {
						sequence.sbSeqA.insert(0, "_");
						sequence.sbSeqB.insert(0, node.getCharSeqB());
						sequence.score = sequence.score + gap;
					} else if (connected == Connected.NW) {
						sequence.sbSeqA.insert(0, node.getCharSeqA());
						sequence.sbSeqB.insert(0, node.getCharSeqB());
						if (node.getCharSeqA().equals(node.getCharSeqB())) {
							sequence.score = sequence.score + match;
						} else {
							sequence.score = sequence.score + misMatch;
						}
					} else {
						sequence.sbSeqA.insert(0, "_");
						sequence.sbSeqB.insert(0, "_");
					}

					listNode.add(nextNode.getNode());
					findAlignNode(listNode, nextNode, listConnecteds, sequence);
					break;
				}
			}
		}
	}

	private NodeController align(NodeController nodeController, Connected connected) {

		if (nodeController.getNode().getConnected() != null) {
			if (nodeController.getNode().getConnected().contains(connected)) {
				return nodeController.getNodeControle(connected);
			}
		}

		return null;
	}

	public DataRetorn nodeVicinity(DataRetorn dataRetorn, Node nodeOld, Node node) {

		if (dataRetorn == null) {
			dataRetorn = new DataRetorn();
			dataRetorn.setArrayNodeAlign(new ArrayList<Node>());
			dataRetorn.setScore(0);
			dataRetorn.setSbSeqA(new StringBuffer());
			dataRetorn.setSbSeqB(new StringBuffer());
		}

		NodeController nodeController = organizeNode.getControllers().get(node);

		if (nodeOld != null) {
			dataRetorn.getArrayNodeAlign().add(node);

			NodeController nodeOldController = organizeNode.getControllers().get(nodeOld);

			if (nodeController.getNode() != nodeOldController.getNode()) {
				if (nodeOldController.getNodeW() == nodeController.getNode()) {
					dataRetorn.getSbSeqA().insert(0, nodeOld.getCharSeqA() != null ? nodeOld.getCharSeqA() : "_");
					dataRetorn.getSbSeqB().insert(0, "_");
					dataRetorn.setScore(dataRetorn.getScore() + gap);
				} else if (nodeOldController.getNodeW() == nodeController.getNode()) {
					dataRetorn.getSbSeqA().insert(0, "_");
					dataRetorn.getSbSeqB().insert(0, nodeOld.getCharSeqB() != null ? nodeOld.getCharSeqB() : "_");
					dataRetorn.setScore(dataRetorn.getScore() + gap);
				} else if (nodeOldController.getNodeNW() == nodeController.getNode()) {
					dataRetorn.getSbSeqA().insert(0, nodeOld.getCharSeqA() != null ? nodeOld.getCharSeqA() : "_");
					dataRetorn.getSbSeqB().insert(0, nodeOld.getCharSeqB() != null ? nodeOld.getCharSeqB() : "_");
					if (nodeOld.getCharSeqA().equals(node.getCharSeqB())) {
						dataRetorn.setScore(dataRetorn.getScore() + match);
					} else {
						dataRetorn.setScore(dataRetorn.getScore() + misMatch);
					}
				} else {
					dataRetorn.getSbSeqA().insert(0, "_");
					dataRetorn.getSbSeqB().insert(0, "_");
				}
			}
		}

		List<Node> arrayNode = new ArrayList<>();

		for (Connected c : node.getConnected()) {
			arrayNode.add(nodeController.getNodeControle(c).getNode());
		}

		dataRetorn.setArrayNode(arrayNode);
		return dataRetorn;
	}

	public void setInputResultAlign(InputResultAlign inputResultAlign) {
		this.inputResultAlign = inputResultAlign;
	}

	public void setInputAlign(InputAlign inputAlign) {
		this.inputAlign = inputAlign;
	}

	public OutputResultAlign getOutputResultAlign() {
		return outputResultAlign;
	}

	public OutputAlign getOutputAlign() {
		return outputAlign;
	}

	private class Sequence {
		StringBuilder sbSeqA = new StringBuilder();
		StringBuilder sbSeqB = new StringBuilder();
		Integer score = 0;
	}
}