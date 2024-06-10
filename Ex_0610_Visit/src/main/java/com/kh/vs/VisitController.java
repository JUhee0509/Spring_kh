package com.kh.vs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.Common;
import dao.VisitDAO;
import vo.VisitVO;


@Controller
public class VisitController {
	
	VisitDAO visit_dao;
	
	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	//전체목록 보기
	@RequestMapping(value= {"/", "list.do"})
	public String list(Model model) {
		List<VisitVO> list = visit_dao.selectVisit();
		model.addAttribute("list", list);//바인딩
		return Common.Visit.VIEW_PATH + "visit_list.jsp";//포워딩
	}
	//새글 입력 폼
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return Common.Visit.VIEW_PATH + "visit_insert_form.jsp";
	}
	//새글 입력
	@RequestMapping("/insert.do") //HttpServletRequest request->ip 찾을때 사용 
	public String insertVisit(VisitVO vo, HttpServletRequest request) {
		String ip = request.getRemoteAddr();//ip를 받아오기
		vo.setIp(ip);//vo에 ip넣어주기
		
		//비밀번호 암호화를 위한 클래스 호출
		String encodePwd = Common.SecurePwd.encodePwd(vo.getPwd());
		vo.setPwd(encodePwd);//암호화된 비밀번호로 vo 객체  갱신
		
		visit_dao.insert(vo);
		return "redirect:list.do";
	}
	// 글 삭제
	@RequestMapping("delete.do")
	@ResponseBody
	public String delete(VisitVO vo) {
		boolean inValid = Common.SecurePwd.decodePwd(vo, visit_dao);
		if(inValid) {
			//실제 삭제
			int res_del = visit_dao.delete(vo.getIdx());
			if (res_del > 0) {
				//삭제성공
				return "[{'result':'clear'}]";
			}else {
				//삭제실패
				return "[{'result':'fail'}]";
			}
		}else {
			//비밀번호가 틀린경우
			return "[{'result':'no'}]";
		}
	}
}
