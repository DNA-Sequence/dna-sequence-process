package br.com.samuelklein.dna.formula;

import br.com.samuelklein.dna.bean.Node;
import br.com.samuelklein.dna.bean.enums.Connected;

public class NodeController {

    private Node node;

    private Integer positionA;
    private Integer positionB;

    private Node nodeN;

    private Node nodeW;

    private Node nodeS;

    private Node nodeE;

    private Node nodeNE;

    private Node nodeNW;

    private Node nodeSE;

    private Node nodeSW;

    private NodeController nodeControllerN;

    private NodeController nodeControllerW;

    private NodeController nodeControllerS;

    private NodeController nodeControllerE;

    private NodeController nodeControllerNE;

    private NodeController nodeControllerNW;

    private NodeController nodeControllerSE;

    private NodeController nodeControllerSW;

    private String valueA;

    private String valueB;

    /**
     * @param node
     * @param positionA
     * @param positionB
     */
    public NodeController(Node node, Integer positionA, Integer positionB) {
        this.node = node;
        this.positionA = positionA;
        this.positionB = positionB;
    }

    public boolean isPossibleN_NW_W() {

        if (node.getValue() != null) {
            return false;
        }

        if (nodeN != null) {
            if (nodeN.getValue() == null) {
                return false;
            }
        }

        if (nodeNW != null) {
            if (nodeNW.getValue() == null) {
                return false;
            }
        }

        if (nodeW != null) {
            if (nodeW.getValue() == null) {
                return false;
            }
        }

        return true;
    }

    /**
     * @return the node
     */
    public Node getNode() {
        return node;
    }

    /**
     * @return the positionA
     */
    public Integer getPositionA() {
        return positionA;
    }

    /**
     * @return the positionB
     */
    public Integer getPositionB() {
        return positionB;
    }

    /**
     * @return the nodeN
     */
    public Node getNodeN() {
        return nodeN;
    }

    /**
     * @return the nodeW
     */
    public Node getNodeW() {
        return nodeW;
    }

    /**
     * @return the nodeS
     */
    public Node getNodeS() {
        return nodeS;
    }

    /**
     * @return the nodeE
     */
    public Node getNodeE() {
        return nodeE;
    }

    /**
     * @return the nodeNE
     */
    public Node getNodeNE() {
        return nodeNE;
    }

    /**
     * @return the nodeNW
     */
    public Node getNodeNW() {
        return nodeNW;
    }

    /**
     * @return the nodeSE
     */
    public Node getNodeSE() {
        return nodeSE;
    }

    /**
     * @return the nodeSW
     */
    public Node getNodeSW() {
        return nodeSW;
    }

    /**
     * @return the nodeControllerN
     */
    public NodeController getNodeControllerN() {
        return nodeControllerN;
    }

    /**
     * @return the nodeControllerW
     */
    public NodeController getNodeControllerW() {
        return nodeControllerW;
    }

    /**
     * @return the nodeControllerS
     */
    public NodeController getNodeControllerS() {
        return nodeControllerS;
    }

    /**
     * @return the nodeControllerE
     */
    public NodeController getNodeControllerE() {
        return nodeControllerE;
    }

    /**
     * @return the nodeControllerNE
     */
    public NodeController getNodeControllerNE() {
        return nodeControllerNE;
    }

    /**
     * @return the nodeControllerNW
     */
    public NodeController getNodeControllerNW() {
        return nodeControllerNW;
    }

    /**
     * @return the nodeControllerSE
     */
    public NodeController getNodeControllerSE() {
        return nodeControllerSE;
    }

    /**
     * @return the nodeControllerSW
     */
    public NodeController getNodeControllerSW() {
        return nodeControllerSW;
    }

    /**
     * @return the valueA
     */
    public String getValueA() {
        return valueA;
    }

    /**
     * @return the valueB
     */
    public String getValueB() {
        return valueB;
    }

    public NodeController getNodeControle(Connected connected) {
        switch (connected) {
            case N:
                return nodeControllerN;
            case S:
                return nodeControllerS;
            case W:
                return nodeControllerW;
            case E:
                return nodeControllerE;
            case NE:
                return nodeControllerNE;
            case NW:
                return nodeControllerNW;
            case SE:
                return nodeControllerSE;
            case SW:
                return nodeControllerSW;
        }

        return null;
    }

    public void setNode(Connected connected, Node node) {

        switch (connected) {

            case N:
                nodeN = node;
                break;
            case W:
                nodeW = node;
                break;
            case S:
                nodeS = node;
                break;
            case E:
                nodeE = node;
                break;
            case NE:
                nodeNE = node;
                break;
            case NW:
                nodeNW = node;
                break;
            case SE:
                nodeSE = node;
                break;
            case SW:
                nodeSW = node;
                break;
        }
    }

    public void setNodeController(Connected connected, NodeController nodeController) {

        switch (connected) {
            case N:
                nodeControllerN = nodeController;
                break;
            case W:
                nodeControllerW = nodeController;
                break;
            case S:
                nodeControllerS = nodeController;
                break;
            case E:
                nodeControllerE = nodeController;
                break;
            case NE:
                nodeControllerNE = nodeController;
                break;
            case NW:
                nodeControllerNW = nodeController;
                break;
            case SE:
                nodeControllerSE = nodeController;
                break;
            case SW:
                nodeControllerSW = nodeController;
                break;
        }
    }

    public void setSequenceNode(char sequenceNodeType, String value) {

        switch (sequenceNodeType) {
            case 'A':
                valueA = value;
                break;
            case 'B':
                valueB = value;
                break;
        }
    }
}