package board.model;

import java.util.List;

public interface BoardDao {

	// 전체 게시글 수 가져오기
	public int selectPostCount();

	// 게시글 목록(list)가져오기
	public List<BoardVo> selectPostList(int startNum, int endNum);
	
	// 최근입력번호
	public int selectMaxNum();
	
	// 답글일 때 step바꾸기
	public void updateReplyStep(int ref, int step);
	
	// 게시글 저장
	public void insertPost(BoardVo vo);	

	// 업로드 정보 DB에 저장
	public void insertUploadInfo(BoardUploadVo upVo);
	
	// 조회수 올리기
	public void updateReadCount(int num);
	
	// 게시글 가져오기
	public BoardVo selectPost(int num);
	
	// 업로드 정보 가져오기
	public BoardUploadVo selectUpload(int num);
	
	// 게시글 수정 처리
	public void updatePosting(BoardVo postVo);
	
	// 업로드파일 수정
	public void updateUploading(BoardUploadVo upVo);
	
	// 게시글 삭제
	public void deletePost(int num);
	
	// 업로드 파일 삭제
	public void deleteUpload(int num);
}
