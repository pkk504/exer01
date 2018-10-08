<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
<style type="text/css">
	select, input, option  {
		font-size: 13px;
		padding: 5pt;
		font-family: 맑은 고딕;	
	}
</style>
</head>
<body>
	<div align="center">
		<h1 style="text-decoration: underline;">Spring MVC Theater</h1>
		<h3>안시성 13:00 ~ </h3>
		<h2>좌석배치도</h2>
		<div style="width: 500px;height: 50px; background-color: silver; ">
			<b>S C R E E N </b>
		</div>
		<form action="${pageContext.servletContext.contextPath}/ticket/order.do"id="f">
			<c:forEach var="row" begin="1" end="5">
				<p>
					<c:forEach var="col" begin="1" end="8">
						<input type="checkbox"name="seater" value="${row}-${col }" onchange="save(this)"id="count">${row}-${col }
					</c:forEach>
				</p>
			</c:forEach>
			<button type="submit">예약신청</button>
		</form>
	</div>
	
		 <script>
		 document.getElementById("f").onsubmit = function( ){
			
				var c = document.getElementById("count").value;
				if(t =="" || m =="" || c=="") {
					return false;
				}
			}
		 
		 
		 
		 
	var names =new Array();

	
	var save = function(target) {
		if(target.checked){
			if(names.length < ${sessionScope.num}) {
				names.push(target.value);
			} else if(!names.length < ${sessionScope.num}){
				window.alert("최대" +${sessionScope.num}+"개까지 선택가능합니다.");
				target.checked = false;
			}
		}else {
			var idx = names.indexOf(target.value);
			names.splice(idx, 1);
		}
		/* //document.getElementsByTagName("span")[0].innerHTML = names.toString();
		var s = document.getElementsByTagName("span")[0];
		s.innerHTML = names.toString(); */
	};
		//basic05 part02 04ex(02)
		
	</script> 
	
	
	
</body>
</html>