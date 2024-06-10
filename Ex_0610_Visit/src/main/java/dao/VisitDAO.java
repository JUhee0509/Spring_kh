package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//전체 목록 불러오기
	public List<VisitVO> selectVisit(){
		List<VisitVO> list = sqlSession.selectList("v.visit_list");
		return list;
	}
	
	//새글 추가
	public int insert(VisitVO vo) {
		int res = sqlSession.insert("v.visit_insert", vo);
		return res;
	}
	
	//비밀번호 일치 확인
	public VisitVO check(int idx) { 
		VisitVO vo = sqlSession.selectOne("v.select_one",idx );
		return vo;
	}
	public int delete(int idx) {
		int res = sqlSession.insert("v.visit_delete", idx);
		return res;
	}
}
