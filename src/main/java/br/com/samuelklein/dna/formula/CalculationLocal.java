package br.com.samuelklein.dna.formula;

import java.util.ArrayList;
import java.util.List;

import br.com.samuelklein.dna.bean.InputAlign;
import br.com.samuelklein.dna.bean.Node;
import br.com.samuelklein.dna.bean.enums.Connected;
import br.com.samuelklein.dna.bean.enums.MethodSequencing;

public class CalculationLocal extends AbstractCalculation {

    public CalculationLocal(InputAlign inputAlign) {
        super(inputAlign);
    }

    @Override
    public void calculationNode() {
        super.calculationNode();

        TravelsNode.travels(outputAlign.getMatrixs().get(0), new ListenerTravelsNode() {
                    @Override
                    public void node(Node node, int i, int j) {
                        calculationNodeGlobal(organizeNode.getControllers().get(node));
                    }
                });

    }

    public void calculationNodeGlobal(NodeController nodeController) {
        setGaps();
        saveValue(nodeController);
    }

    private void saveValue(NodeController nodeController) {
        NodeController nnw = nodeController.getNodeControllerNW();
        NodeController nn = nodeController.getNodeControllerN();
        NodeController nw = nodeController.getNodeControllerW();

        if (nnw != null && nnw.getNode().getValue() == null) {
            return;
        }

        if (nn != null && nn.getNode().getValue() == null) {
            return;
        }

        if (nw != null && nw.getNode().getValue() == null) {
            return;
        }

        List<Connected> connecteds = new ArrayList<Connected>();

        nodeController.getNode().setConnected(connecteds);

        if (nnw == null && nn == null && nw == null) {
            nodeController.getNode().setValue(0);
            return;
        }

        if (nw == null) {
            int value = getInt(nn.getNode().getValue()) + gap;
            if (value < 0) {
                value = 0;
            }
            nodeController.getNode().setValue(value);
            connecteds.add(Connected.N);
            return;
        }

        if (nn == null) {
            int value = getInt(nw.getNode().getValue()) + gap;
            if (value < 0) {
                value = 0;
            }

            nodeController.getNode().setValue(value);
            connecteds.add(Connected.W);
            return;
        }

        int valueN = getInt(nn.getNode().getValue()) + gap;
        int valueW = getInt(nw.getNode().getValue()) + gap;
        int valueNW = 0;

        if (valueN < 0) {
            valueN = 0;
        }
        if (valueW < 0) {
            valueW = 0;
        }

        if (nodeController.getValueA().equals(nodeController.getValueB())) {
            valueNW = getInt(nnw.getNode().getValue()) + match;
        } else {
            valueNW = getInt(nnw.getNode().getValue()) + misMatch;
        }

        if (valueNW < 0) {
            valueNW = 0;
        }

        if (valueN >= valueNW && valueN >= valueW) {
            connecteds.add(Connected.N);
        }

        if (valueW >= valueNW && valueW >= valueN) {
            connecteds.add(Connected.W);
        }

        if (valueNW >= valueW && valueNW >= valueN) {
            connecteds.add(Connected.NW);
        }

        if (connecteds.contains(Connected.N)) {
            nodeController.getNode().setValue(valueN);
            return;
        }

        if (connecteds.contains(Connected.NW)) {
            nodeController.getNode().setValue(valueNW);
            return;
        }

        if (connecteds.contains(Connected.W)) {
            nodeController.getNode().setValue(valueW);
            return;
        }
    }

    public void findAligns() {

        Node[][] nodes = outputAlign.getMatrixs().get(0).getNodes();

        int posx = nodes.length;
        int posy = nodes[0].length;

        for (int i = 1; i < posx; i++) {
            NodeController nodeController = organizeNode.getControllers().get(nodes[i][posy - 1]);
            findAlignsNode(nodeController);
        }

        for (int i = 1; i < posy - 1; i++) {
            NodeController nodeController = organizeNode.getControllers().get(nodes[posx - 1][i]);
            findAlignsNode(nodeController);
        }

    }

    public MethodSequencing getMethodSequencing() {
        return MethodSequencing.LOCAL;
    }
}