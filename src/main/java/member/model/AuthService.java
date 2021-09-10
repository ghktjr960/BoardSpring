package member.model;

public class AuthService {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("setMemberDao(MemberDao memberDao)");
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(String id, String password) {
		MemberVo vo = memberDao.selectId(id);
		if(vo == null) {
			throw new MemberNotFoundException();
		}
		if(!vo.getPassword().equals(password)) {
			throw new IdPasswordNotMatchingException();
		}
		return new AuthInfo(vo.getId(), vo.getName());
	}
	
}
