package de.management.exceptions;

public class ParamMissingException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParamMissingException(String param){
        super("Angabe: '" + param + "' fehlt");
    }

}
