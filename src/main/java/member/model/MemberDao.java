package member.model;

public interface MemberDao {
	// 아이디에 해당하는 정보가져오기(중복확인, 로그인에 사용)
	public MemberVo selectId(String id);
	
	// 회원가입
	public void insert(MemberVo vo);
	
	// 회원정보 수정
	public void updateInfo(MemberVo vo);
	
	// 비밀번호 변경
	public void updatePwd(MemberVo vo);

	// 회원 탈퇴
	public void delete(MemberVo vo);
}
