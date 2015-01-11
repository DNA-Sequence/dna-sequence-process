package br.com.samuelklein.dna.bean;

import java.io.Serializable;
import java.util.List;

import br.com.samuelklein.dna.json.UtilJson;

public class OutputResultAlign implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Node> nodes;
    private String resultSequenceA;
    private String resultSequenceB;
    private Integer score;

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public String getResultSequenceA() {
        return resultSequenceA;
    }

    public void setResultSequenceA(String resultSequenceA) {
        this.resultSequenceA = resultSequenceA;
    }

    public String getResultSequenceB() {
        return resultSequenceB;
    }

    public void setResultSequenceB(String resultSequenceB) {
        this.resultSequenceB = resultSequenceB;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean first = true;

        if (UtilJson.testNull(nodes)) {
            sb.append(UtilJson.getJson("nodes", nodes.toArray()));
            first = false;
        }
        if (UtilJson.testNull(resultSequenceA)) {
            if (!first) {
                sb.append(",");
            }

            sb.append(UtilJson.getJson("resultSequenceA", resultSequenceA));
            first = false;
        }
        if (UtilJson.testNull(resultSequenceB)) {
            if (!first) {
                sb.append(",");
            }

            sb.append(UtilJson.getJson("resultSequenceB", resultSequenceB));
            first = false;
        }

        if (UtilJson.testNull(score)) {
            if (!first) {
                sb.append(",");
            }

            sb.append(UtilJson.getJson("score", score));
            first = false;
        }

        sb.append("}");
        return sb.toString();
    }

}
