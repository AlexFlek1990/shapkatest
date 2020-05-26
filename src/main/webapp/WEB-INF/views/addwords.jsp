<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <script>
        function submitForm() {
            var frm = document.getElementsByName('addwordForm')[0];
            frm.submit(); // Submit the form
            frm.reset();  // Reset all form data
            return false; // Prevent page refresh
        }
    </script>
</head>
<body>
<h2>Add Word!</h2>
<form name="addwordForm" action ="/shapka/words/addwords" method="post" modelAttribute="word">
    <input type="text" name="word"><br>
    <input type="button" value="Submit" id="btnsubmit" onclick="submitForm()">
</form>
<c:forEach items="${wordList}" var="word">
    <p>${word.getValue()}</p>
</c:forEach>
</body>
</html>
