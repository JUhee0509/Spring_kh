<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>사원 추가 창</title>
		<script>
			function send(f) {
				//유효성 검사 나중에
				
				f.action = "insert.do";
				f.submit();
			}
		</script>
	</head>
	
	<body>
		<form>
			<table border="1" align="center">
				<caption>사원 추가</caption>
				<tr>
					<th>사번</th>
					<td><input name="sabun"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input name="saname"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input name="sagen"></td>
				</tr>
				<tr>
					<th>부서</th>
					<td><input name="deptno"></td>
				</tr>
				<tr>
					<th>직급</th>
					<td><input name="sajob"></td>
				</tr>
				<tr>
					<th>입사일</th>
					<td><input name="sahire"></td>
				</tr>
				<tr>
					<th>상사번호</th>
					<td><input name="samgr"></td>
				</tr>
				<tr>
					<th>연봉</th>
					<td><input name="sapay"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="사원 추가" onclick="send(this.form)">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>