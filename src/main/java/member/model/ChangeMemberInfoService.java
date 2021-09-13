package member.model;

import java.util.Date;

public class ChangeMemberInfoService {
	private MemberDao memberDao;

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void changeMemberInfo(String id, String name, String email, Date birthday) {
		MemberVo vo = getMemberInfo(id);
		if(vo == null) {
			throw new MemberNotFoundException();
		}
		vo.changeMemberInfo(name, email, birthday);
		memberDao.updateInfo(vo);
	}
	
	public MemberVo getMemberInfo(String id) {
		return memberDao.selectId(id);
	}
	
}
