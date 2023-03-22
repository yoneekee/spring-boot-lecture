<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index.jsp</title>
</head>
<body>
    <c:set var="title" value="jstl로 만들어 보는 제목입니다." />
    <h1>jsp index</h1>
    <h1>${name}</h1>
    <h2><c:out value="${title}" /></h2>
</body>
</html>
