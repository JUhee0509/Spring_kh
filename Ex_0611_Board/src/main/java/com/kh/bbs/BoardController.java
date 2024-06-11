package com.kh.bbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BoardDAO;
import util.Common;
import util.Paging;
import vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	BoardDAO board_dao;
	public BoardController(BoardDAO board_dao) {
		this.board_dao = board_dao;
	}
	@RequestMapping(value= {"/","/list.do"})
	public String list( Model model, String page, String search, String search_text) {
		int nowPage = 1;
		if(page != null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}
		
		//한 페이지에 표시되는 게시물의 시작과 끝 번호를 계산
		//?page=2
		int start = (nowPage - 1) * Common.Board.BLOCKLIST +1;
		int end = start + Common.Board.BLOCKLIST - 1;
		
		//start, end변수를 Map저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		//검색할 내용이 있다면
		if(search != null && !search.equals("all")) {
			if (search.equals("name_subject_content")) {
				map.put("name", search_text);
				map.put("subject", search_text);
				map.put("content", search_text);
			}else if (search.equals("name")){
				map.put("name", search_text);
			}else if (search.equals("subject")) {
				map.put("subject", search_text);
			}else if (search.equals("content")) {
				map.put("content", search_text);
			}
		}
		//전체목록 가져오기
		List<BoardVO> list = board_dao.selectList(map);
		
		//전체 게시글 수 가져오기
		int row_total = board_dao.getRowTotal(map);
		
		//페이지 메뉴 생성
		String search_param = String.format("search=%s&search_text=%S", search, search_text);
		
		String pageMenu = Paging.getPaging("list.do", nowPage, row_total, search_param,
											Common.Board.BLOCKLIST, Common.Board.BLOCKPAGE);
		
		//list객체 바인딩 및 포워딩
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		//조회수 증가를 위해 기록되있던 show정보 삭제
		 session.removeAttribute("show");
		
		return Common.Board.VIEW_PATH + "board_list.jsp";
	}
	//게시글 상세보기
	@RequestMapping("/view.do")
	public String view(Model model, int idx) {

		//상세보기를 위한 게시글 조회
		BoardVO vo = board_dao.selectOne(idx);
		
		//조회수 무한증가 방지를 위한 세션
		String show = (String)session.getAttribute("show");
		
		if(show == null) {
			//조회수 증가
			board_dao.update_readhit(idx);
			session.setAttribute("show", "");
		}
		
		//바인딩
		model.addAttribute("vo", vo);
		return Common.Board.VIEW_PATH+"Board_view.jsp";
	}
	
	@RequestMapping("/board_write.do")
	public String board_form() {
		return Common.Board.VIEW_PATH+"board_write.jsp";
	}
	@RequestMapping("/insert.do")
	public String insert(BoardVO vo) {
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		board_dao.insert(vo);
		
		return "redirect:list.do";
	}
}
