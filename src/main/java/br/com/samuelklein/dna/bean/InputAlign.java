package br.com.samuelklein.dna.bean;

import java.io.Serializable;

import br.com.samuelklein.dna.bean.enums.MethodSequencing;
import br.com.samuelklein.dna.bean.enums.TypeElement;

public class InputAlign implements Serializable {

    private static final long serialVersionUID = -7588803232325496752L;

    private Integer id;

    private String sequenceA;

    private String sequenceB;

    private TypeElement typeElement;

    private MethodSequencing methodSequencing;

    public String getSequenceA() {
        return sequenceA;
    }

    public void setSequenceA(String sequenceA) {
        this.sequenceA = sequenceA;
    }

    public String getSequenceB() {
        return sequenceB;
    }

    public void setSequenceB(String sequenceB) {
        this.sequenceB = sequenceB;
    }

    public TypeElement getTypeElement() {
        return typeElement;
    }

    public void setTypeElement(TypeElement typeElement) {
        this.typeElement = typeElement;
    }

    public MethodSequencing getMethodSequencing() {
        return methodSequencing;
    }

    public void setMethodSequencing(MethodSequencing methodSequencing) {
        this.methodSequencing = methodSequencing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
