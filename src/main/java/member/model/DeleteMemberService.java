package member.model;

public class DeleteMemberService {
	private MemberDao memberDao;

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void deleteMember(String id, String pwd) {
		MemberVo vo = memberDao.selectId(id);
		if(vo.matchPwd(pwd)) {
			memberDao.delete(vo);
		} else {
			throw new IdPasswordNotMatchingException();
		}
	}

}
