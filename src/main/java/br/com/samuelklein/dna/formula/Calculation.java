package br.com.samuelklein.dna.formula;

import br.com.samuelklein.dna.bean.DataRetorn;
import br.com.samuelklein.dna.bean.InputResultAlign;
import br.com.samuelklein.dna.bean.Node;
import br.com.samuelklein.dna.bean.OutputAlign;
import br.com.samuelklein.dna.bean.OutputResultAlign;
import br.com.samuelklein.dna.bean.enums.MethodSequencing;

public interface Calculation {

	public OutputAlign getOutputAlign();

	public OutputResultAlign getOutputResultAlign();

	public void setInputResultAlign(InputResultAlign inputResultAlign);

	public void calculationNode();

	public void findAligns();

	public void findAlign();

	public DataRetorn nodeVicinity(DataRetorn dataRetorn, Node nodeOld, Node Node);

	public MethodSequencing getMethodSequencing();

}