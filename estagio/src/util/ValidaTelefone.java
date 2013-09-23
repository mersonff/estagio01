package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidaTelefone implements Validator {
	
	public void validate(FacesContext facesContext, UIComponent uIComponent, Object object) throws ValidatorException {
        
		String telefone = (String) object;
		Pattern path = Pattern.compile("[(][0-9][0-9][)][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
		Matcher mat = path.matcher(telefone);
		
		/*
	    String enteredEmail = (String)object;
	    Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
	    Matcher m = p.matcher(enteredEmail);
	    */

	    boolean matchFound = mat.matches();
	    

	    if (!matchFound) {
	        FacesMessage message = new FacesMessage();
	        message.setDetail("Telefone incorreto!");
	        message.setSummary("Telefone incorreto!");
	        message.setSeverity(FacesMessage.SEVERITY_ERROR);
	        throw new ValidatorException(message);
	    }
	}

}
