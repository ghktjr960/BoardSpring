package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.AuthInfo;
import member.model.DeleteMemberService;
import member.model.IdPasswordNotMatchingException;

@Controller
@RequestMapping("/deleteMember")
public class DeleteMemberController {
	private DeleteMemberService deleteMemberService;

	public DeleteMemberService getDeleteMemberService() {
		return deleteMemberService;
	}

	public void setDeleteMemberService(DeleteMemberService deleteMemberService) {
		this.deleteMemberService = deleteMemberService;
	}
	
	@GetMapping
	public String deleteForm(@ModelAttribute("deleteCommand")DeleteMemberCommand deleteCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		session.setAttribute("deleteInfo", authInfo);
		return "/delete/deleteForm";
	}
	
	@PostMapping
	public String deleteSubmit(@ModelAttribute("deleteCommand")DeleteMemberCommand deleteCommand, Errors errors, HttpSession session) {
		if(errors.hasErrors()) {
			return "/delete/deleteForm";
		}
		System.out.println(deleteCommand.getId());
		System.out.println(deleteCommand.getName());
		System.out.println(deleteCommand.getPassword());
		try {
			deleteMemberService.deleteMember(deleteCommand.getId(), deleteCommand.getPassword());
			return "/delete/deleteSuccess";
		} catch (IdPasswordNotMatchingException e) {
			e.printStackTrace();
			errors.rejectValue("password", "notMatching");
			return "/delete/deleteForm";
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "/delete/deleteForm";
		}
	}
}
