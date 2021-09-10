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
@RequestMapping("/register")
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
		System.out.println("register Get요청");
		model.addAttribute("formData", new RegisterRequest());
		return "register/form";
	}
	
	@PostMapping
	public String registProc(@ModelAttribute("formData")RegisterRequest regq, Errors errors) {
		System.out.println("register Post요청");
		
		System.out.println("post요청에서 생년월일 뽑아보기 : "+regq.getBirthday());
		new RegisterRequestValidator().validate(regq, errors);
		if(errors.hasErrors()) {
			return "register/form";
		}
		try {
			registerService.regist(regq);
			return "register/success";
		} catch (AlreadyExistingMemberException e) {
			errors.rejectValue("id", "duplicate");
			return "register/form";
		}
	}
}
