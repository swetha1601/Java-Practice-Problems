<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Form with Validation</title>
    <script>
        function validateForm() {
            var name = document.getElementById("name").value;
            var email = document.getElementById("email").value;
 
            // Name validation
            if (name.trim() === "") {
                alert("Name cannot be empty!");
                return false;
            }
 
            // Email validation using regex
            var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(email)) {
                alert("Invalid email format!");
                return false;
            }
 
            return true;
        }
    </script>
</head>
<body>
    <h1>Enter USER DETAILS</h1>
 
    <!-- Form with onsubmit validation -->
    <form action="process.jsp" method="post" onsubmit="return validateForm()">
        <label for="name">Enter Name:</label>
        <input type="text" id="name" name="name" required>
        <br><br>
 
        <label for="email">Enter Email:</label>
        <input type="email" id="email" name="email" required>
        <br><br>
 
        <input type="submit" value="Submit">
    </form>
</body>
</html>