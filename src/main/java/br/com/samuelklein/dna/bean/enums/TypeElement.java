package br.com.samuelklein.dna.bean.enums;

public enum TypeElement {

    PROTEIN, NUCLEOTIDE;

    public String toString() {
        return "\"" + name() + "\"";
    }

    ;

}