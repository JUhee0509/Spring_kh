package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {
	
	SqlSession sqlSession;
	public DeptDAO( SqlSession sqlSession ) {
		this.sqlSession = sqlSession;
	}
	
	//부서목록 가져오기
	public List<DeptVO> selectDept(){
		
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		return list;
		
	}
	
	//새 부서 추가
	public int insert( DeptVO vo ) {
		int res = sqlSession.insert("d.dept_insert", vo);
		return res;
	}
	
	//부서삭제
	public int deleteDept(int no) {
		int res = sqlSession.delete("d.dept_delete", no);
		return res;
	}
	
	//부서수정폼
	public DeptVO selectOne(int deptno) {
		DeptVO vo = sqlSession.selectOne("d.select_one", deptno);
		return vo;
	}
	
	//부서정보 수정
	public int update( Map<String, Object> map ) {
		int res = sqlSession.update("d.dept_update", map);
		return res;
	}
}


















