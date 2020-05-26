<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
</head>
<body>
<h2>Users:</h2>

<c:forEach items="${userList}" var="user">
    <p>${user.toString()}</p>
</c:forEach>
</body>
</html>