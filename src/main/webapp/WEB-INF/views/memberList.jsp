<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 명부</title>
</head>
<body>
	<c:forEach items="${memberList}" var="member">
		${member.mid } / ${member.mpw } / ${member.mname } / ${member.memail } / ${member.mdate }
		<br><br>
	</c:forEach>
</body>
</html>