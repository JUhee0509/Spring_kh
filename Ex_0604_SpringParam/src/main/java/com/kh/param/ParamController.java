package com.kh.param;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.PersonVO;

@Controller
public class ParamController {
	public static final String VIEW_PATH = "/WEB-INF/views/person/";
	
	@RequestMapping(value={"/","insert_form.do"})
	public String insert_form() {
		
		return VIEW_PATH + "insert_form.jsp";
	}
	
	//send1() 처리
	@RequestMapping("/insert1.do")
	public String insert1( Model model, String name, int age, String pwd ) { //들어오는 파라미터 이름과 맞춰서 출력
				//insert1.do?name=홍		&age=11		&pwd=11
		//name, age, pwd변수로 같은 이름에 파라미터값이 자동으로 저장된다.
		PersonVO vo = new PersonVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setPwd(pwd);
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "insert_result.jsp";
	}
	
	@RequestMapping("/insert2.do")
	public String insert2(Model model, PersonVO vo) {
		//insert1.do?name=홍&age=11&pwd=11
		//파라미터를 넘어온 값을 vo에 속성이 일치하는 변수에 자동으로 세팅
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "insert_result.jsp";
	}
	
}
