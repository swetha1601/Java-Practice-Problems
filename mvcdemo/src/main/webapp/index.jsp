<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Form</title>
</head>
<body>
<h2>Enter User Details</h2>
<form action="processForm" method="post">
        Name: <input type="text" name="username"><br>
        Email: <input type="email" name="email"><br>
<input type="submit" value="Submit">
</form>
</body>
</html>