package br.com.samuelklein.dna.exception;

public class CalculationException extends Exception {

    private static final long serialVersionUID = 4943273897841472160L;

    public CalculationException() {
        super();
    }

    public CalculationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculationException(String message) {
        super(message);
    }

    public CalculationException(Throwable cause) {
        super(cause);
    }

}