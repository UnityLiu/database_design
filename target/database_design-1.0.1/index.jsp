<html>
<body>
    <h2>Hello World!</h2>
    <%
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        //重定向到登录页面

    %>

</body>
</html>
