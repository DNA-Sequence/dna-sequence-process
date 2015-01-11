package br.com.samuelklein.dna.formula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.samuelklein.dna.bean.Matrix;
import br.com.samuelklein.dna.bean.Node;
import br.com.samuelklein.dna.bean.enums.Connected;

public class OrganizeNode {

	protected Matrix matrix;
	private String sequenceA;
	private String sequenceB;
	private Map<Node, NodeController> controllers = new HashMap<Node, NodeController>();

	/**
	 * @param matrix
	 */
	public OrganizeNode(Matrix matrix) {
		super();
		this.matrix = matrix;
	}

	public void addNode(Node node, Integer positionA, Integer positionB) {
		addNode(new NodeController(node, positionA, positionB));
	}

	public void addNode(NodeController node) {
		controllers.put(node.getNode(), node);
	}

	public void execute(Node node) {
		if (controllers.containsKey(node)) {
			execute(controllers.get(node));
		}
	}

	public void execute(NodeController node) {
		for (Connected c : Connected.values()) {
			NodeController nodeFound = searchNode(node, c);
			if (nodeFound != null) {
				node.setNodeController(c, nodeFound);
				node.setNode(c, nodeFound.getNode());
			}
		}

		node.setSequenceNode('A', getValuesSequence('A', node));
		node.setSequenceNode('B', getValuesSequence('B', node));
	}

	private String getValuesSequence(char value, NodeController node) {
		if (value == 'A') {
			if (node.getPositionA() == 0) {
				return "";
			}

			return sequenceA.charAt(node.getPositionA() - 1) + "";
		} else if (value == 'B') {
			if (node.getPositionB() == 0) {
				return "";
			}

			return sequenceB.charAt(node.getPositionB() - 1) + "";
		}

		return "";
	}

	private NodeController searchNode(NodeController node, Connected value) {
		int posA = node.getPositionA();
		int posB = node.getPositionB();
		Node[][] nodes = matrix.getNodes();

		try {

			switch (value) {
			case N:
				posB -= 1;
				break;
			case S:
				posB += 1;
				break;
			case W:
				posA -= 1;
				break;
			case E:
				posA += 1;
				break;
			case NW:
				posA -= 1;
				posB -= 1;
				break;
			case NE:
				posA += 1;
				posB -= 1;
				break;
			case SW:
				posA -= 1;
				posB += 1;
				break;
			case SE:
				posA += 1;
				posB += 1;
				break;
			}

			if (posA < 0 || posB < 0 || sequenceB.length() < posB || sequenceA.length() < posA) {
				return null;
			}

			Node nodeFound = nodes[posA][posB];

			if (nodeFound != null) {
				if (controllers.containsKey(nodeFound)) {
					return controllers.get(nodeFound);
				}
			}
			return null;
		} catch (Exception e) {

		}
		return null;
	}

	public void organize() {

		TravelsNode.travels(matrix, new ListenerTravelsNode() {

			@Override
			public void node(Node node, int i, int j) {
				addNode(node, i, j);
			}
		});

		TravelsNode.travels(matrix, new ListenerTravelsNode() {

			@Override
			public void node(Node node, int i, int j) {
				execute(node);
			}
		});

	}

	public Map<Node, NodeController> getControllers() {
		return controllers;
	}

	/**
	 * @return the sequenceA
	 */
	public String getSequenceA() {
		return sequenceA;
	}

	/**
	 * @param sequenceA
	 *            the sequenceA to set
	 */
	public void setSequenceA(String sequenceA) {
		this.sequenceA = sequenceA;
	}

	/**
	 * @return the sequenceB
	 */
	public String getSequenceB() {
		return sequenceB;
	}

	/**
	 * @param sequenceB
	 *            the sequenceB to set
	 */
	public void setSequenceB(String sequenceB) {
		this.sequenceB = sequenceB;
	}

	public List<Node> getArrayMaxNodeControllerSemiGlobal() {
		List<Node> arrayMax = new ArrayList<>();

		Node[][] nodes = this.matrix.getNodes();
		int i = 0;

		Node node = null;

		for (i = 0; i < nodes.length; i++) {
			node = nodes[i][nodes[0].length - 1];

			if (arrayMax.size() == 0) {
				arrayMax.add(node);
			} else {
				int iNode = node.getValue() == null ? 0 : node.getValue();
				int iArrayNode = arrayMax.get(0).getValue() == null ? 0 : arrayMax.get(0).getValue();

				if (iNode == iArrayNode) {
					arrayMax.add(node);
				} else if (iArrayNode < iNode) {
					arrayMax = new ArrayList<>();
					arrayMax.add(node);
				}
			}
		}
		for (i = 0; i < nodes[0].length; i++) {
			node = nodes[nodes.length - 1][i];
			if (arrayMax.size() == 0) {
				arrayMax.add(node);
			} else {
				int iNode = node.getValue() == null ? 0 : node.getValue();
				int iArrayNode = arrayMax.get(0).getValue() == null ? 0 : arrayMax.get(0).getValue();

				if (iNode == iArrayNode) {
					arrayMax.add(node);
				} else if (iArrayNode < iNode) {
					arrayMax = new ArrayList<>();
					arrayMax.add(node);
				}
			}
		}

		return arrayMax;
	}
}