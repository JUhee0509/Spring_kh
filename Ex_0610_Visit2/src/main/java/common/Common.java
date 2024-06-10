package common;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dao.VisitDAO;
import vo.VisitVO;

public class Common {
	public static class Visit{
		public static final String VIEW_PATH = "/WEB-INF/views/visit/";
	}
	public static class SecurePwd{
		
		//비밀번호  암호화 메서드
		public static String encodePwd(String pwd) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodePwd = encoder.encode(pwd);//비밀번호 암호화
			return encodePwd;
		}
		//비밀번호 복호화 메서드
		public static boolean decodePwd(VisitVO vo, VisitDAO visit_dao) {
			boolean inValid = false;
			
			VisitVO resultVO = visit_dao.check(vo.getIdx());
			
			if(resultVO != null) {
				//입력한 비밀번호와, DB의 암호화된 비밀번호가 이리하면
				//inValid가 ture가 된다
				inValid = BCrypt.checkpw(vo.getPwd(),resultVO.getPwd());
			}
			return inValid;
		}
	}
}
