package br.com.samuelklein.dna.bean;

import java.io.Serializable;

import br.com.samuelklein.dna.json.UtilJson;

public class Matrix implements Serializable {

    private static final long serialVersionUID = 5739829442854984324L;

    private Node[][] nodes;

    private String[] sequenceA;

    private String[] sequenceB;

    public Node[][] getNodes() {
        return nodes;
    }

    public void setNodes(Node[][] nodes) {
        this.nodes = nodes;
    }

    public String[] getSequenceA() {
        return sequenceA;
    }

    public void setSequenceA(String[] sequenceA) {
        this.sequenceA = sequenceA;
    }

    public String[] getSequenceB() {
        return sequenceB;
    }

    public void setSequenceB(String[] sequenceB) {
        this.sequenceB = sequenceB;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (UtilJson.testNull(nodes)) {
            sb.append(UtilJson.getJson("nodes", nodes));
        }
        if (UtilJson.testNull(nodes) && UtilJson.testNull(sequenceA)) {
            sb.append(",");
        }
        if (UtilJson.testNull(sequenceA)) {
            sb.append(UtilJson.getJson("sequenceA", sequenceA));
        }
        if (UtilJson.testNull(sequenceB) && UtilJson.testNull(sequenceA)) {
            sb.append(",");
        }
        if (UtilJson.testNull(sequenceB)) {
            sb.append(UtilJson.getJson("sequenceB", sequenceB));
        }

        sb.append("}");

        return sb.toString();
    }

}