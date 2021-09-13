package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.AuthInfo;
import member.model.ChangePwdService;
import member.model.IdPasswordNotMatchingException;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	private ChangePwdService changePwdService;

	public ChangePwdService getChangePwdService() {
		return changePwdService;
	}

	public void setChangePwdService(ChangePwdService changePwdService) {
		this.changePwdService = changePwdService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String changePwdForm(@ModelAttribute("pwdCommand")ChangePwdCommand pwdcmd) {
		return "/edit/changePwdForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String changePwdSubmit(@ModelAttribute("pwdCommand")ChangePwdCommand pwdCmd, Errors errors, HttpSession session) {
		if(errors.hasErrors()) {
			return "/edit/changePwdForm";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		try {
			changePwdService.changePwd(authInfo.getId(), pwdCmd.getCurrentPwd(), pwdCmd.getNewPwd());
			return "/edit/changePwdSuccess";
		} catch(IdPasswordNotMatchingException e) {
			e.printStackTrace();
			errors.rejectValue("currentPwd", "notMatching");
			return "/edit/changePwdForm";
		}
	}
}
