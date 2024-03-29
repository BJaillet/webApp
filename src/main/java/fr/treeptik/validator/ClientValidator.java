package fr.treeptik.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.model.Client;

@Component
public class ClientValidator implements Validator {

	@Override
	public boolean supports(Class<?> client) {
		return client.getClass().equals(Client.class);
	}

	@Override
	public void validate(Object c, Errors errors) {
		Client client = (Client) c;
		if (client.getAge()<0 || client.getAge()>100) {
			errors.rejectValue("age", "erreur.age");
		}
	}
	

	
}
