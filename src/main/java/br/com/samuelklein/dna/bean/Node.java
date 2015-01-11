package br.com.samuelklein.dna.bean;

import java.io.Serializable;
import java.util.List;

import br.com.samuelklein.dna.bean.enums.Connected;
import br.com.samuelklein.dna.json.UtilJson;

public class Node implements Serializable {

    private static final long serialVersionUID = 8417742476495754744L;

    private Integer value;

    private List<Connected> connected;

    private Boolean candidate;

    private Integer x;
    private Integer y;

    private String charSeqA;
    private String charSeqB;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Connected> getConnected() {
        return connected;
    }

    public void setConnected(List<Connected> connected) {
        this.connected = connected;
    }

    public Boolean getCandidate() {
        return candidate;
    }

    public void setCandidate(Boolean candidate) {
        this.candidate = candidate;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getCharSeqA() {
        return charSeqA;
    }

    public void setCharSeqA(String charSeqA) {
        this.charSeqA = charSeqA;
    }

    public String getCharSeqB() {
        return charSeqB;
    }

    public void setCharSeqB(String charSeqB) {
        this.charSeqB = charSeqB;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        boolean first = true;

        if (UtilJson.testNull(value)) {
            sb.append(UtilJson.getJson("value", value));
            first = false;
        }

        if (UtilJson.testNull(connected)) {
            if (!first) {
                sb.append(",");
            }
            sb.append(UtilJson.getJson("connected", connected.toArray()));
            first = false;
        }

        if (UtilJson.testNull(candidate)) {
            if (!first) {
                sb.append(",");
            }
            sb.append(UtilJson.getJson("candidate", candidate));
            first = false;
        }

        if (UtilJson.testNull(x)) {
            if (!first) {
                sb.append(",");
            }
            sb.append(UtilJson.getJson("x", x));
            first = false;
        }

        if (UtilJson.testNull(y)) {
            if (!first) {
                sb.append(",");
            }
            sb.append(UtilJson.getJson("y", y));
            first = false;
        }

        if (UtilJson.testNull(charSeqA)) {
            if (!first) {
                sb.append(",");
            }
            sb.append(UtilJson.getJson("charSeqA", charSeqA));
            first = false;
        }

        if (UtilJson.testNull(charSeqB)) {
            if (!first) {
                sb.append(",");
            }
            sb.append(UtilJson.getJson("charSeqB", charSeqB));
        }

        sb.append("}");

        return sb.toString();
    }
}