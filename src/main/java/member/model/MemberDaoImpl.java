package member.model;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDaoImpl implements MemberDao {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		System.out.println("MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate)");
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public MemberVo selectId(String id) {
		return sqlSessionTemplate.selectOne("selectId", id);
	}
	
	@Override
	public void insert(MemberVo vo) {
		sqlSessionTemplate.insert("insert", vo);
	}
	
	@Override
	public void updateInfo(MemberVo vo) {
		sqlSessionTemplate.update("updateMemberInfo", vo);
	}
	
	@Override
	public void updatePwd(MemberVo vo) {
		sqlSessionTemplate.update("updateMemberPwd", vo);
		
	}
	
	@Override
	public void delete(String id) {
		sqlSessionTemplate.delete("delete", id);
	}
}
