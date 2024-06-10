<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- ${pageContext.request.contextPath}/resources/css/visit.css -->
		<link rel="stylesheet" href="/vs/resources/css/visit.css">
		
		<script src="/vs/resources/js/httpRequest.js"></script>
		
		<script>
			function del(f) {
				
				let idx = f.idx.value;
				let c_pwd = f.c_pwd.value;//입력받은 비번
				
				let url = "delete.do";
				let param = "idx="+idx+"&pwd="+encodeURIComponent(c_pwd);
				sendRequest(url, param, resultFn, "post");
			}
			function resultFn() {
				if(xhr.readyState == 4 & xhr.status == 200){
					let data = xhr.responseText;
					let json = (new Function('return ' +data))();
					
					if(json[0].result == 'no') {
						alert("비밀번호 불일치");
						return;
					}
					if(json[0].result == 'fail') {
						alert("삭제실패");
						return;
					}else{
						alert("삭제성공");
						location.href = "list.do";
					}
				}
			}
		</script>
		</head>
	<body>
		<div id="main_box">
			<h1>::: 방 명 록 :::</h1>
			
			<div align="center">
				<input type="button" value="글쓰기" onclick="location.href= 'insert_form.do'">
			</div>
			<c:forEach var="vo" items="${ list }">
				<div class="visit_box">
					<div class="type_content"><pre>${ vo.content }</pre> </div>
					<div class="type_name"> 작성자 : ${vo.name }(${vo.ip}) </div>
					<div class="type_regdate"> 작성일 : ${vo.regdate } </div>
					<form>
						<input type="hidden" name="idx" value="${vo.idx }">
						<input type="hidden" name="pwd" value="${vo.pwd }">
						비밀번호<input type="password" name="c_pwd">
						
						<input type="button" value="수정" onclick="modify(this.form)">
						<input type="button" value="삭제" onclick="del(this.form)">
					</form>
				</div>
			</c:forEach>
		</div>
	</body>
</html>