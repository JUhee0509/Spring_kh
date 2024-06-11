package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.SawonVO;

public class SawonDAO {
	
	SqlSession sqlSession;
	public SawonDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<SawonVO> selectSawon(){
		
		List<SawonVO> list = sqlSession.selectList("s.sawon_list");
		return list;
	}
	public int insert(SawonVO vo) {
		int res = sqlSession.insert("s.sawon_insert", vo);
		return res;
	}
	public int delete(int sabun) {
		int res = sqlSession.insert("s.sawon_delete", sabun);
		return res;
	}
	public SawonVO selectOne (int sabun) {
		SawonVO vo = sqlSession.selectOne("s.sawon_one", sabun);
		return vo;
	}
	public int update(Map<String, Object> map) {
		int res = sqlSession.update("s.sawon_update", map);
		return res;
	}
}
