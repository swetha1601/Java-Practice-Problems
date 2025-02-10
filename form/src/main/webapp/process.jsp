<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Submission</title>
</head>
<body>
    <h1>Form Submission Details</h1>
 
    <%
        // Retrieving parameters from form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
 
        // Server-side validation
        if (name == null || name.trim().isEmpty()) {
    %>
        <p style="color: red;">Error: Name cannot be empty!</p>
        <a href="index.jsp">Go Back</a>
    <%
        } else if (email == null || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
    %>
        <p style="color: red;">Error: Invalid email format!</p>
        <a href="index.jsp">Go Back</a>
    <%
        } else {
    %>
        <p><strong>Name:</strong> <%= name %></p>
        <p><strong>Email:</strong> <%= email %></p>
        <a href="index.jsp">Go Back</a>
    <%
        }
    %>
</body>
</html>