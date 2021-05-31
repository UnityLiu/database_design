<%--
  Created by IntelliJ IDEA.
  User: unityliu
  Date: 2021/5/30
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        let flag = 0;
        function load(){
            let xmlhttp = new XMLHttpRequest()
            xmlhttp.onreadystatechange = function (){
                if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                    flag++;
                    <%--alert("${pageContext.request.contextPath}");--%>
                    document.getElementById("mp").innerText = xmlhttp.responseText+flag;
                }
            }
            xmlhttp.open("get","${pageContext.request.contextPath}/ajaxtest",true);
            xmlhttp.send();
        }
    </script>
</head>
<body>
    <p id="mp" onclick="load()">1234</p>
</body>
</html>
