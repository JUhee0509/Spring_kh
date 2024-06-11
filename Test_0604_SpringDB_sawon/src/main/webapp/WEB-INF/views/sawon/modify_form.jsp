<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>사원 수정 판</title>
		
		<script src="/db/resources/js/httpRequest.js"></script>
		
		<script>
			function modify(f) {
				let url = "modify.do";
				let param= "sabun="+f.sabun.value+"&re_sabun="+f.re_sabun.value+"&saname="+f.saname.value+"&sagen="+f.sagen.value+
						   "&deptno="+f.deptno.value+"&sajob="+f.sajob.value+"&sahire="+f.sahire.value+"&samgr="+f.samgr.value+"&sapay="+f.sapay.value;
				sendRequest(url, param, resultFn, "GET");
			}
			function resultFn() {
				if(xhr.readyState == 4 && xhr.status == 200){
					let data = xhr.responseText;
					
					if(data =='no'){
						alert("수정실패");
						return;
					}else{
						alert("수정성공");
						location.href="list.do";
					}
				}
			}
		</script>
	</head>
	
	<body>
		<form>
			<input type="hidden" name="sabun" value="${vo.sabun}">
			<table border="1" align="center">
				<caption>사원 수정</caption>
				<tr>
					<th>사번</th>
					<td><input name="re_sabun" value="${vo.sabun}"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input name="saname" value="${vo.saname}"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input name="sagen" value="${vo.sagen}"></td>
				</tr>
				<tr>
					<th>부서</th>
					<td><input name="deptno" value="${vo.deptno}"></td>
				</tr>
				<tr>
					<th>직급</th>
					<td><input name="sajob" value="${vo.sajob}"></td>
				</tr>
				<tr>
					<th>입사일</th>
					<td><input name="sahire" value="${vo.sahire}"></td>
				</tr>
				<tr>
					<th>상사번호</th>
					<td><input name="samgr" value="${vo.samgr}"></td>
				</tr>
				<tr>
					<th>연봉</th>
					<td><input name="sapay" value="${vo.sapay}"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="수정 하기" onclick="modify(this.form)"></td>
				</tr>
			</table>
		</form>
	</body>
</html>