<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script>
			function del(no){
				if( !confirm("삭제 하시겠습니까") ){
					return;
				}
				
				location.href="del_dept.do?deptno="+no;
				
			}
		</script>
		
	</head>
	
	<body>
	
		<table border="1" align="center">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th colspan="3">위치</th>
			</tr>
			
			<c:forEach var="vo" items="${ list }">
			<tr>
				<td>${ vo.deptno }</td>
				<td>${ vo.dname }</td>
				<td>${ vo.loc }</td>
				
				<td>
					<input type="button" value="수정" 
					       onclick="location.href='modify_form.do?deptno=${vo.deptno}'">
				</td>
				
				<td>
					<input type="button" value="삭제"
					       onclick="del('${vo.deptno}');">
				</td>
				
			</tr>
			</c:forEach>
			
			<tr>
				<td colspan="5">
					<input type="button" value="추가" 
					       onclick="location.href='insert_form.do'">
				</td>
			</tr>
			
		</table>
		
	</body>
</html>



















