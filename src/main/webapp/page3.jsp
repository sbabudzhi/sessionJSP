<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%
    String name3 = request.getParameter("lastname");
    session.setAttribute("name3", name3);
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Поздравляю!</h2>
<p> Добро пожаловать, </p>
</body>
<%
    PrintWriter oute = response.getWriter();
    oute.println(session.getAttribute("name3") + " " +
            session.getAttribute("name") + " " +
            session.getAttribute("name2")); %>
</html>