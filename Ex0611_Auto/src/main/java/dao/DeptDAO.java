package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.DeptVO;

/*@component
ㄴ@Controller
ㄴ@service
ㄴ@Repository */
//컴포넌트 이노테이션의 자식
@Repository("dept_dao")
public class DeptDAO {
	
	SqlSession sqlSession;
	
	//생성자 호출
	//자동 연결
	@Autowired
	public DeptDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("---DEPTDAO 생성자---");
	}
	public List<DeptVO> selectList(){
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		return list;
		
	}
}
