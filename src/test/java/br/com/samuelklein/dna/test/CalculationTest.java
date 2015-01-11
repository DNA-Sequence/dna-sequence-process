package br.com.samuelklein.dna.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.samuelklein.dna.bean.InputAlignGlobalLocal;
import br.com.samuelklein.dna.bean.InputResultAlign;
import br.com.samuelklein.dna.bean.enums.Connected;
import br.com.samuelklein.dna.bean.enums.MethodSequencing;
import br.com.samuelklein.dna.bean.enums.TypeElement;
import br.com.samuelklein.dna.exception.CalculationException;
import br.com.samuelklein.dna.formula.Calculation;
import br.com.samuelklein.dna.formula.CalculationFactory;

import com.google.gson.Gson;

public class CalculationTest {

	private InputAlignGlobalLocal inputAlign;
	private InputResultAlign inputResultAlign;

	@Before
	public void begin() {
		inputAlign = new InputAlignGlobalLocal();
		inputAlign.setMethodSequencing(MethodSequencing.LOCAL);
		inputAlign.setSequenceA("GAATTCAGTTA");
		inputAlign.setSequenceB("GGATCGA");
		inputAlign.setTypeElement(TypeElement.NUCLEOTIDE);
		inputAlign.setGap(-4);
		inputAlign.setMatch(5);
		inputAlign.setMisMatch(-3);
		inputResultAlign = new InputResultAlign();

		System.out.println(inputAlign.getSequenceA());
		System.out.println(inputAlign.getSequenceB());

		List<Connected> connecteds = new ArrayList<>();
		connecteds.add(Connected.NW);
		connecteds.add(Connected.N);
		connecteds.add(Connected.W);
		inputResultAlign.setConnecteds(connecteds);

	}

	@Test
	public void testCalculationMatrix() throws CalculationException {
		Gson g = new Gson();
		// System.out.println(g.toJson(inputAlign));

		Calculation c = CalculationFactory.createCalculation(inputAlign);
		c.calculationNode();
		c.findAligns();

		System.out.println(c.getOutputAlign());
		System.out.println(g.toJson(c.getOutputAlign()));

		c.setInputResultAlign(inputResultAlign);
		c.findAlign();

		System.out.println(g.toJson(c.getOutputResultAlign()));
		System.out.println(c.getOutputResultAlign().getScore());

	}
}