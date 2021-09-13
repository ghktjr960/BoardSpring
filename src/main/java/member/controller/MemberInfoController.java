package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.MemberDao;
import member.model.MemberVo;

@Controller
public class MemberInfoController {
	private MemberDao memberDao;

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@RequestMapping("/member/{id}")
	public String memberInfo(@PathVariable("id")String id, Model model) {
		System.out.println("memebrInfoController에서 id확인 : " + id);
		MemberVo vo = memberDao.selectId(id);
		model.addAttribute("memberInfo", vo);
		return "member/memberInfo";
	}
	
	
}
