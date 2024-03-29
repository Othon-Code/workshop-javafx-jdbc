package model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Map<String, String> errors = new HashMap<>();/// uma colecao de pares =chave e valor. o 1� da chave e o
															/// segundo do valor

	public ValidationException(String msg) {
		super(msg);
	}

	public Map<String, String> getErrors() {
		return errors;
	}
	public void addError(String nomeCampo, String msgErro) {
		errors.put(nomeCampo, msgErro);
	}
	
}
