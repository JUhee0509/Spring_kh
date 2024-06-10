package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.SawonDAO;
import vo.SawonVO;

@Controller
public class SawonController {
	
	public static final String VIEW_PATH = "/WEB-INF/views/sawon/";
	
	SawonDAO sawon_dao;
	public SawonController(SawonDAO sawon_dao) {
		this.sawon_dao = sawon_dao;
	}
	
	@RequestMapping(value = {"/","list.do"})
	public String list(Model model) {
		List<SawonVO> list = sawon_dao.selectSawon();
		model.addAttribute("list", list);
		return VIEW_PATH + "sawon_list.jsp";
	}
	//사원 추가 공간 만들기
	@RequestMapping("insert_form.do")
	public String insertForm() {
		return VIEW_PATH + "insert_form.jsp";
	}
	//사원 추가
	@RequestMapping("insert.do")
	public String insertDept(SawonVO vo) {
		sawon_dao.insert(vo);
		return "redirect:list.do";
	}
	//사원 삭제
	@RequestMapping("del_sawon.do")
	public String delform(int sabun) {
		sawon_dao.delete(sabun);
		return "redirect:list.do";
	}
	//사원 정보 수정 공간
	@RequestMapping("modify_form.do")
	public String modifyForm(Model model, int sabun) {
		SawonVO vo = sawon_dao.selectOne(sabun);
		model.addAttribute("vo", vo);
		return VIEW_PATH + "modify_form.jsp";
	}
	@RequestMapping("modify.do")
	@ResponseBody
	public String modify(SawonVO vo, int re_sabun) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vo", vo);
		map.put("re_sabun", re_sabun);
		int res = sawon_dao.update(map);
		
		String result = "no";
		if( res > 0) {
			result = "yes";
		}
		//콜백메서드로 최종 결과값 전달
		return result;
	}
}
