package com.kh.vs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVO;

@Controller
public class JsonMakerController {
	
	@RequestMapping("/vo_to_json.do")
	@ResponseBody
	public PersonVO vo_to_json() {
		PersonVO p = new PersonVO();
		p.setName("홍길동");
		p.setAge(20);
		p.setAddr("서울시 관악구");
		
		return p;
	}
	
	@RequestMapping("/map_to_json.do")
	@ResponseBody
	public Map<String, Object> map_to_json(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "홍길동");
		map.put("age", 22);
		
		Map<String, String> telmap = new HashMap<String, String>();
		telmap.put("home_tel", "02-1111-1111");
		telmap.put("office_tel", "02-3333-2222");
		
		map.put("tel", telmap);
		
		return map;
		
	}
	@RequestMapping("/list_to_json.do")
	@ResponseBody
	public List<PersonVO> list_to_json(){
		List<PersonVO> list = new ArrayList<PersonVO>();
		PersonVO p1 = new PersonVO();
		p1.setName("홍길동");
		p1.setAge(20);
		p1.setAddr("서울시 관악구");
		
		PersonVO p2 = new PersonVO();
		p2.setName("홍길동");
		p2.setAge(20);
		p2.setAddr("서울시 관악구");
		
		list.add(p1);
		list.add(p2);
		
		return list;
	}
}
