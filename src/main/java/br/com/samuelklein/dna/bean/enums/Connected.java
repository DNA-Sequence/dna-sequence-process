package br.com.samuelklein.dna.bean.enums;


public enum Connected {
    /**
     * &#8593; north
     */
    N,
    /**
     * &#8592; west
     */
    W,
    /**
     * &#8595; south
     */
    S,
    /**
     * &#8594; east
     */
    E,
    /**
     * &#8598; northwest
     */
    NW,
    /**
     * &#8599; northeast
     */
    NE,
    /**
     * &#8600; southeast
     */
    SE,
    /**
     * &#8601; southwest
     */
    SW;

    public String toString() {
        return "\"" + name() + "\"";
    }

    ;
}