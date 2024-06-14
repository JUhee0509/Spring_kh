<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="js/httpRequest.js"></script>
		<script>
			window.onload = function() {
				
				let url = "../list.do";
				sendRequest(url,null,resultFn,"get");
			}
			function resultFn() {
				if(xhr.readyState == 4 && xhr.status == 200){
					
					let data = xhr.responseText;
					let json = JSON.parse(data);
					
					let display_data = "";
					for(let i = 0; i < json.length; i++){
						display_data = display_data + (json[i].name+"/"+json[i].content) +"<br>";
					}
					let disp = document.getElementById("disp");
					disp.innerHTML = display_data;
				}
			}
		</script>
	</head>
	
	<body>
		<div id="disp">
		
		</div>
	</body>
</html>