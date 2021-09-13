package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.AuthInfo;
import member.model.ChangeMemberInfoService;
import member.model.MemberNotFoundException;
import member.model.MemberVo;

@Controller
@RequestMapping("/edit/changeMemberInfo")
public class ChangeMemberInfoController {
	private ChangeMemberInfoService changeMemberInfoService;

	public ChangeMemberInfoService getChangeMemberInfoService() {
		return changeMemberInfoService;
	}

	public void setChangeMemberInfoService(ChangeMemberInfoService changeMemberInfoService) {
		this.changeMemberInfoService = changeMemberInfoService;
	}
	
	@GetMapping
	public String changeMemberInfoForm(@ModelAttribute("infoCommand")ChangeMemberInfoCommand infoCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		MemberVo vo = changeMemberInfoService.getMemberInfo(authInfo.getId());
		session.setAttribute("memberInfo", vo);
		return "/edit/changeMemberInfoForm";
	}
	
	@PostMapping
	public String changeMemberInfoSubmit(@ModelAttribute("infoCommand")ChangeMemberInfoCommand infoCommand, Errors errors, HttpSession session) {
		new ChangeMemberInfoCommandValidator().validate(infoCommand, errors);
		if(errors.hasErrors()) {
			return "/edit/changeMemberInfoForm";
		}
		try {
			changeMemberInfoService.changeMemberInfo(
					infoCommand.getId(), 
					infoCommand.getName(), 
					infoCommand.getEmail(), 
					infoCommand.getBirthday()
					);
			return "/edit/changeMemberInfoSuccess";
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			return "/edit/changeMemberInfoForm";
		}
	}
}
