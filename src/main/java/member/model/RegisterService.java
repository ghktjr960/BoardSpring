package member.model;

import java.util.Date;

public class RegisterService {
	private MemberDao memberDao;
	
	public RegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest regq) {
		System.out.println("RegisterService : regist(RegisterRequest regq)");
		MemberVo memberCheck = memberDao.selectId(regq.getId());
		if(memberCheck != null) {
			throw new AlreadyExistingMemberException(regq.getId() + "은 이미 존재하는 아이디입니다.");
		} else {
			System.out.println(regq.getBirthday());
			MemberVo newVo = new MemberVo(
									regq.getId(), 
									regq.getPassword(), 
									regq.getBirthday(), 
									regq.getName(), 
									regq.getGender(), 
									regq.getEmail(), 
									new Date());
			memberDao.insert(newVo);
		}
		
	}
}
