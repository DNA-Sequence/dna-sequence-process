package br.com.samuelklein.dna.bean;

import java.io.Serializable;
import java.util.List;

import br.com.samuelklein.dna.bean.enums.Connected;

public class InputResultAlign implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idMatrix;
    private Matrix matrix;
    private List<Connected> connecteds;

    /**
     * user in align local position X of matrix
     */
    private Integer idPosX;
    /**
     * user in align local position Y of matrix
     */
    private Integer idPosY;
    /**
     * user in align local position X and Y of matrix result NODE
     */
    private Node node;

    public Integer getIdMatrix() {
        return idMatrix;
    }

    public void setIdMatrix(Integer idMatrix) {
        this.idMatrix = idMatrix;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public List<Connected> getConnecteds() {
        return connecteds;
    }

    public void setConnecteds(List<Connected> connecteds) {
        this.connecteds = connecteds;
    }

    public Integer getIdPosX() {
        return idPosX;
    }

    public void setIdPosX(Integer idPosX) {
        this.idPosX = idPosX;
    }

    public Integer getIdPosY() {
        return idPosY;
    }

    public void setIdPosY(Integer idPosY) {
        this.idPosY = idPosY;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

}
