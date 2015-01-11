package br.com.samuelklein.dna.bean;

import java.io.Serializable;
import java.util.List;

import br.com.samuelklein.dna.json.UtilJson;

public class OutputAlign implements Serializable {

    private static final long serialVersionUID = 550130850327626471L;

    private Integer id;

    private List<Matrix> matrixs;

    public List<Matrix> getMatrixs() {
        return matrixs;
    }

    public void setMatrixs(List<Matrix> matrixs) {
        this.matrixs = matrixs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        if (UtilJson.testNull(id)) {
            sb.append(UtilJson.getJson("id", id));
            sb.append(",");
        }
        if (UtilJson.testNull(matrixs)) {
            sb.append(UtilJson.getJson("matrixs", matrixs.toArray()));
        }

        sb.append("}");
        return sb.toString();
    }

}