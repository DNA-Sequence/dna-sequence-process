package br.com.samuelklein.dna.bean.enums;

public enum MethodSequencing {
	/**
	 * NEEDLEMAN-WUNSCH
	 */
	GLOBAL,
	/**
	 * SMITH-WATERMAN
	 */
	LOCAL,

	/**
     * 
     */
	SEMIGLOBAL;

	public String toString() {
		return "\"" + name() + "\"";
	}

}