<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <script>
        function submitForm() {
            var frm = document.getElementsByName('fillUser')[0];
            frm.submit(); // Submit the form
            frm.reset();  // Reset all form data
            return false; // Prevent page refresh
        }
    </script>
</head>
<body>
<h2>Fill Name</h2>
<form name="fillUser" action ="/shapka/users/adduser" method="post" modelAttribute="user">
    <input type="text" name="name"><br>
    <input type="text" name="password"><br>
    <input type="button" value="Submit" id="usersubmit" onclick="submitForm()">
</form>


</body>
</html>