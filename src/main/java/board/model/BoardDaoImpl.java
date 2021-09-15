package board.model;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class BoardDaoImpl implements BoardDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BoardDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		System.out.println("BoardDaoImpl()");
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int selectPostCount() {
		return sqlSessionTemplate.selectOne("selectPostCount");
	}
	
	@Override
	public List<BoardVo> selectPostList(int startNum, int endNum) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSessionTemplate.selectList("selectPostList", map);
	}
	
	@Override
	public int selectMaxNum() {
		return sqlSessionTemplate.selectOne("selectMaxNum");
	}
	
	@Override
	public void updateReplyStep(int ref, int step) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("ref", ref);
		map.put("step", step);
		sqlSessionTemplate.update("updateReplyStep", map);
	}
	
	@Override
	public void insertPost(BoardVo vo) {
		sqlSessionTemplate.insert("insertPost", vo);
	}
	
	@Override
	public void insertUploadInfo(BoardUploadVo upVo) {
		sqlSessionTemplate.insert("insertUploadInfo", upVo);
	}
	
	@Override
	public void updateReadCount(int num) {
		sqlSessionTemplate.update("updateReadCount", num);
	}
	
	@Override
	public BoardVo selectPost(int num) {
		return sqlSessionTemplate.selectOne("selectPost", num);
	}
	
	@Override
	public BoardUploadVo selectUpload(int num) {
		return sqlSessionTemplate.selectOne("selectUpload", num);
	}
	
	@Override
	public void updatePosting(BoardVo postVo) {
		sqlSessionTemplate.update("updatePosting", postVo);
	}
	
	@Override
	public void updateUploading(BoardUploadVo upVo) {
		sqlSessionTemplate.update("updateUploading", upVo);
	}
	
	@Override
	public void deletePost(int num) {
		sqlSessionTemplate.delete("deletePost", num);
	}
	
	@Override
	public void deleteUpload(int num) {
		sqlSessionTemplate.delete("deleteUpload", num);
	}
	
	
}
