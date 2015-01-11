package br.com.samuelklein.dna.formula;

import br.com.samuelklein.dna.bean.InputAlign;
import br.com.samuelklein.dna.exception.CalculationException;

public class CalculationFactory {

	public static Calculation createCalculation(InputAlign inputAlign) throws CalculationException {

		if (inputAlign != null) {
			switch (inputAlign.getMethodSequencing()) {
			case GLOBAL:
				return new CalculationGlobal(inputAlign);
			case LOCAL:
				return new CalculationLocal(inputAlign);
			case SEMIGLOBAL:
				return new CalculationSemiGlobal(inputAlign);
			}
		}

		throw new CalculationException("Method Sequencing not defined");
	}
}