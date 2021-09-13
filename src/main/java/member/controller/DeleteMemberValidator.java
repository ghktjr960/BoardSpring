package member.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DeleteMemberValidator implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		return DeleteMemberCommand.class.isAssignableFrom(arg0);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
	}
}
