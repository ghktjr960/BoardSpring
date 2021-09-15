package board.controller;

import java.util.List;

import board.model.BoardVo;

public class ListCommand {
	private int currentPage;
	private int startNum;
	private int endNum;
	private int count;
	private int pageSize;
	private int postNum;
	private List<BoardVo> postList;
	
	public ListCommand() {

	}
	
	public ListCommand(int currentPage, int startNum, int endNum, int count, int pageSize, int postNum, List<BoardVo> postList) {
		this.currentPage = currentPage;
		this.startNum = startNum;
		this.endNum = endNum;
		this.count = count;
		this.pageSize = pageSize;
		this.postNum = postNum;
		this.postList = postList;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public List<BoardVo> getPostList() {
		return postList;
	}
	public void setPostList(List<BoardVo> postList) {
		this.postList = postList;
	}
	
}
