package br.com.samuelklein.dna.bean;

import java.io.Serializable;
import java.util.List;

public class DataRetorn implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<Node> arrayNode;
    private List<Node> arrayNodeAlign;
    private int score;
    private StringBuffer sbSeqA;
    private StringBuffer sbSeqB;

    /**
     * @return the arrayNode
     */
    public List<Node> getArrayNode() {
        return arrayNode;
    }

    /**
     * @param arrayNode the arrayNode to set
     */
    public void setArrayNode(List<Node> arrayNode) {
        this.arrayNode = arrayNode;
    }

    /**
     * @return the arrayNodeAlign
     */
    public List<Node> getArrayNodeAlign() {
        return arrayNodeAlign;
    }

    /**
     * @param arrayNodeAlign the arrayNodeAlign to set
     */
    public void setArrayNodeAlign(List<Node> arrayNodeAlign) {
        this.arrayNodeAlign = arrayNodeAlign;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the sbSeqA
     */
    public StringBuffer getSbSeqA() {
        return sbSeqA;
    }

    /**
     * @param sbSeqA the sbSeqA to set
     */
    public void setSbSeqA(StringBuffer sbSeqA) {
        this.sbSeqA = sbSeqA;
    }

    /**
     * @return the sbSeqB
     */
    public StringBuffer getSbSeqB() {
        return sbSeqB;
    }

    /**
     * @param sbSeqB the sbSeqB to set
     */
    public void setSbSeqB(StringBuffer sbSeqB) {
        this.sbSeqB = sbSeqB;
    }

}
