package com.kh.sp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import dao.UserDAO;
import vo.DeptVO;
import vo.UserVO;

@Controller
public class TestController {
	
	DeptDAO deptDAO;
	UserDAO userDAO;
	
	public TestController(DeptDAO deptDAO, UserDAO userDAO) {
		this.deptDAO = deptDAO;
		this.userDAO = userDAO;
	}
	
	@RequestMapping(value={"/","/main.do"})
	public String main_content() {
		return "main_content";
	}
	
	@RequestMapping("/dept_list.do")
	public String deptList( Model model ) {
		//부서목록
		List<DeptVO> list = deptDAO.selectDeptList();
		model.addAttribute("dlist", list);//바인딩
		return "dept_list";
		
	}
	@RequestMapping("/user_list.do")
	public String userList(Model model) {
		List<UserVO> list = userDAO.selectUsetList();
		model.addAttribute("ulist", list);
		return "user_list";
	}
}
