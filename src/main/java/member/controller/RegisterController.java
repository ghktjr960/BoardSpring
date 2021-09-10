package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.AlreadyExistingMemberException;
import member.model.RegisterRequest;
import member.model.RegisterService;

@Controller
@RequestMapping("/regist")
public class RegisterController {
	private RegisterService registerService;
	
	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	@GetMapping
	public String registForm(Model model) {
		model.addAttribute("formData", new RegisterRequest());
		return "register/form";
	}
	
	@PostMapping
	public String registProc(@ModelAttribute("formData")RegisterRequest regq, Errors errors) {
		new RegisterRequestValidator().validate(regq, errors);
		if(errors.hasErrors()) {
			return "register/form";
		}
		try {
			registerService.regist(regq);
			return "register/proc";
		} catch (AlreadyExistingMemberException e) {
			errors.rejectValue("email", "duplicate");
			return "register/proc";
		}
	}
}
