package com.yedam.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService){
		this.boardService = boardService;
	}
	
	//전체조회 기능
	//1) url + Method
	//2)Service
	//3)View
	
	@GetMapping("boardList") // Model = Reqeust + Response
	public String boardList(Model model) {
		// 2) Service
		List<BoardVO> list = boardService.findBoardList();
		// 2-1) Service의 결과를 View에 전달
		model.addAttribute("boards", list);
		// 3) View
		return "board/list";
		//prifix , classpath:/templates/
		//suffix , .html
		
		//prifix + return + suffix
		//classpath:/templates/board/list.html
	}
	
	// 단건조회 : GET + 전달받을 데이터 => QueryString
		// 1) URL + METHOD
		@GetMapping("boardInfo") ///boardInfo?bno=1
		public String boardInfo(BoardVO boardVO, Model model) {
			// 2) Service
			BoardVO findVO = boardService.findBoardByBno(boardVO);
			// 2-1) Service의 결과를 View에 전달
			model.addAttribute("board", findVO);
			// 3) View
			return "board/info";
			//prifix , classpath:/templates/
			//suffix , .html
					
			//prifix + return + suffix
			//classpath:/templates/emp/info.html
		}
	
}
