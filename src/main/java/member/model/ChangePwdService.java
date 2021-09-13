package member.model;

public class ChangePwdService {
	private MemberDao memberDao;
	
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		System.out.println("ChangePwdService(MemberDao memberDao)");
		this.memberDao = memberDao;
	}

	public void changePwd(String id, String currentPwd, String newPwd) {
		MemberVo vo = memberDao.selectId(id);
		if(vo == null) {
			new MemberNotFoundException();
		} else {
			vo.changePwd(currentPwd, newPwd);
			memberDao.updatePwd(vo);
		}
	}
}
