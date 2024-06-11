package util;

import java.security.PublicKey;

public class Common {
	//객체 관리를 편하게 하기위한 클래스
	//게시판 별로 한 페이지에 보여질 게시글 수가 상이 할 수 있으므로
	//관리를 편리하게 할 수 있도록 내부클래스를 활용
	public static class Board{
		
		public static final String VIEW_PATH = "/WEB-INF/views/board/";
		//한 페이지당 보여줄 게시글 수
		public final static int BLOCKLIST = 10;
		//한 화면에 보여지는 페이지 메뉴의 수
		// <- 1 2 3 ->
		public final static int BLOCKPAGE = 3;
	}
	
	//댓글 페이징 관련
	public static class Comment{
		//한 페이지당 보여줄 게시글 수
		public final static int BLOCKLIST = 5;
		//한 화면에 보여지는 페이지 메뉴의 수
		// <- 1 2 3 ->
		public final static int BLOCKPAGE = 3;
	}
}
