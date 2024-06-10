<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>사원 리스트 창</title>
		<script>
			function del(f) {
				if(!confirm("해당사원을 삭제 하실건가요?")){
					return;
				}
				location.href = "del_sawon.do?sabun="+f;
			}
		</script>
	</head>
	
	<body>
		<table border="1" align="center">
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>성별</th>
				<th>부서</th>
				<th>직급</th>
				<th>입사일</th>
				<th>상사번호</th>
				<th>연봉</th>
				<th colspan="2">비고</th>
				
			</tr>
			
			<c:forEach var="vo" items="${ list }">
			<tr>
				<td>${ vo.sabun }</td>
				<td>${ vo.saname }</td>
				<td>${ vo.sagen }</td>
				<td>${ vo.deptno }</td>
				<td>${ vo.sajob }</td>
				<td>${fn:split(vo.sahire,' ')[0]}</td>
				<td>${ vo.samgr }</td>
				<td>${ vo.sapay }</td>
				<td>
					<input type="button" value="수정" onclick="location.href='modify_form.do?sabun=${vo.sabun}'">
				</td>
				<td>
					<input type="button" value="삭제" onclick="del('${vo.sabun}')">
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="10" align="right">
					<input type="button" value="추가" onclick="location.href='insert_form.do'">
				</td>
			</tr>
		</table>
	</body>
</html>