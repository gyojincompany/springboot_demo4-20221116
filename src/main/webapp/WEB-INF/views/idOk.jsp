<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 검색 결과</title>
</head>
<body>
	아이디 검색 결과<br>
	아이디 : ${searchRs.mid }<br>
	비번 : ${searchRs.mpw }<br>
	이름 : ${searchRs.mname }<br>
	이메일 : ${searchRs.memail }<br>
	가입일 : ${searchRs.mdate }<br>
</body>
</html>