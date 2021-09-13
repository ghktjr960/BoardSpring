package member.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ChangeMemberInfoCommandValidator implements Validator{
	
	private static final String emailRegExp = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;
	
	public ChangeMemberInfoCommandValidator() {
		System.out.println("RegisterRequestValidator()");
		pattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		System.out.println("supports(Class<?> arg0)");
		return RegisterRequestValidator.class.isAssignableFrom(arg0);
	}	
	
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate(Object target, Errors errors)");
		
		ChangeMemberInfoCommand changeInfoCommand = (ChangeMemberInfoCommand) target;
		
		System.out.println("생년월일 뽑아보기 : "+ changeInfoCommand.getBirthday());
		
		if(changeInfoCommand.getEmail() == null || changeInfoCommand.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		} else {
			Matcher matcher = pattern.matcher(changeInfoCommand.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "required");
	}
}
