package board.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import board.model.BoardDao;
import board.model.BoardVo;

@Controller
public class ListController {
	private BoardDao boardDao;

	public BoardDao getBoardDao() {
		return boardDao;
	}

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@RequestMapping("/board/list")
	public String postList(@ModelAttribute("list") ListCommand listCommand, Model model, Errors errors,
			HttpServletRequest req) {
		System.out.println("boardlist들어옴");

		List<BoardVo> postList = null;
		int pageSize = 10;
		String pageNum = req.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);

		int startNum = (currentPage - 1) * pageSize + 1;
		int endNum = currentPage * pageSize;

		int count = boardDao.selectPostCount();
		if (count > 0) {
			postList = boardDao.selectPostList(startNum, endNum);
		} else {
			postList = Collections.emptyList();
		}
		int postNum = 0;
		postNum = count - (currentPage - 1) * pageSize;

		ListCommand listComm = new ListCommand(currentPage, startNum, endNum, count, pageSize, postNum, postList);
		model.addAttribute("boards", listComm);
		return "/board/list/boardList";
	}
}
