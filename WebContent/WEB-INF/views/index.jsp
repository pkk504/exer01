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
		width: 30%;
		padding: 5pt;
		font-family: 맑은 고딕;	
	}
</style>
</head>
<body>
	<div align="center">
		<h1 style="text-decoration: underline;">Spring MVC Theater</h1>
		<p style="font-size: smaller;">
			예매확인/취소 메뉴만 이용 가능하며 입력한 정보로만 확인가능합니다.<br /> 입력한 내용을 꼭
			확인해주세요.
		</p>
		<h2>현재상영작</h2>
		<form action="${pageContext.servletContext.contextPath }/ticket/seat.do">
			<p>
				<select name="movie" onchange="moviemo(this);">
					<option value="영화를 선택해주세요">영화를 선택해주세요.</option>
					<option  id="movie"value="안시성">안시성</option>
					 <c:forEach var="m" items="${movies }">
						<option value="${m }">${m }</option>
					</c:forEach> 		
				</select>
			</p>
			<p>
				<select name="time" id="ajaxtime">
					<option value="">상영시관을 선택해주세요.</option>
					 <c:forEach var="h" items="${sessionScope.movietime }">
						 <fmt:formatNumber value="${h }" pattern="00" var="fmth"/>
						<option  value="${fmth }">${fmth }:00</option>
					</c:forEach> 		
				</select>
			</p>
			<p>
				<select name="num">
					<option value="">예약인원을 선택해주세요.</option>
					<c:forEach var="p" begin="1" end="3" step="1">
						<option value="${p }">${p }명</option>
					</c:forEach>		
				</select>
			</p>
			<p>
				<button type="submit">예약진행</button>
			</p>
		</form>
	</div>
	<script >
	var moviemo=function(target){
		var xhr = new XMLHttpRequest();
		var mmm=target.value;
		 /* var param={"moviemomo" : mmm}; */
		 console.log(param);
		 var html="";
		 
		xhr.open("post","${pageContext.servletContext.contextPath}/ticket/zzz.do",true);
		/*  xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded"); */
		  xhr.onreadystatechange =function(){
			if(this.readyState==4){
				var obj = JSON.parse(this.responseText);
				for(var i=0;i<obj.length;i++){
					console.log(obj[i]);
					html+="<option value=\""+obj[i].TIME+"\">"+obj[i].TIME+" 시"+"</option>";
				}
				
				document.getElementById("ajaxtime").innerHTML=html;	
			}
		} 
		 
		  console.log(mmm);
		 var param = JSON.stringify(param);
		 xhr.send(mmm);
	};
	
	</script>
</body>
</html>