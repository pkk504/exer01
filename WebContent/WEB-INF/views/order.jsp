<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${pass!=null }">
<ul>
<li> 이름 : ${sessionScope.nick }</li>
<li> 핸드폰 : ${sessionScope.phon }</li>
<li> 영화 : ${sessionScope.movie }</li>
<li> 시간 : ${sessionScope.time }:00시</li>
<c:forEach var="t" items="${sessionScope.seat }">
					예약 좌석 : ${t}
					</c:forEach>
</ul>
</c:when>
<c:otherwise>
	<h1>예약 실패하셨습니다.!</h1>
</c:otherwise>
</c:choose>

</body>
</html>
