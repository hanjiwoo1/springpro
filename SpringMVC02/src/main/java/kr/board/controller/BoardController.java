package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController{	// new BoardController();
	
	@Autowired
	BoardMapper boardMapper;
	
	@RequestMapping("/")
	public String main() {
		
		return "main";
	}
	
	// @ResponseBody ->jackson-databind (객체를 -> JSON(자바스크립트오브젝트노테이션) 데이터포멧으로 변환)
	@RequestMapping("/boardList.do")
	public @ResponseBody List<Board> boardList(){
		List<Board> list = boardMapper.getLists();
		return list; // 리턴이 jsp, 리다이렉트도 아닌 객체를 응답? -> JSON 데이터 형식으로 변환(API)해서 리턴(응답)하겠다.
					 // 그럴려면 @ResponseBody 어노테이션을 걸어야한다.
	}
}
