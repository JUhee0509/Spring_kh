package dao;

import java.util.ArrayList;
import java.util.List;

import vo.UserVO;

public class UserDAO {
	public List<UserVO> selectUsetList(){
		
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO(1, "홍길동", 20));
		list.add(new UserVO(2, "이길동", 30));
		list.add(new UserVO(3, "삼길동", 40));
		
		return list;
		
	}
}
