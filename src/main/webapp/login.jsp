<%--
  Created by IntelliJ IDEA.
  User: unityliu
  Date: 2021/5/27
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>用户登录</title>
  <!-- 链接到layui框架 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/layui/css/layui.css">
  <style>
    #text{
      color: red;
    }
  </style>
  <script src = "${pageContext.request.contextPath}/static/lib/layui/layui.js"></script>
  <script src = "${pageContext.request.contextPath}/static/lib/jquery-3.6.0.js"></script>
  <script language="JavaScript">



    function setCookie(cname,cvalue,exdays)
    {
      var d = new Date();
      d.setTime(d.getTime()+(exdays*24*60*60*1000));
      var expires = "expires="+d.toGMTString();
      document.cookie = cname + "=" + cvalue + "; " + expires;
    }

    function getCookie(cname)
    {
      var name = cname + "=";
      var ca = document.cookie.split(';');
      for(var i=0; i<ca.length; i++)
      {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
      }
      return "";
    }

    //异步判断登录是否成功
    $(document).ready(function (){
      $("#loginButton").click(function (){
        //三个参数
        //第一个：必需的 URL 参数规定您希望请求的 URL。
        //第二个：可选的 data 参数规定连同请求发送的数据。
        //第三个：可选的 callback 参数是请求成功后所执行的函数名。
        $.get("${pageContext.request.contextPath}/login",$("#form1").serialize(),function (data,status){

          if(data == "false"){
            alert("账户类型、用户名或密码错误...");
          }else{
            alert("登录成功1");
            alert(getCookie('employee_position'));
            switch (getCookie('employee_position')) {
              case '超级管理员':
                location.assign("manager/super_administrator/super_administrator.jsp");
                break;
              case '仓库负责人':
                location.assign("manager/warehouse_header/warehouse_header.jsp");
                break;
              case '仓库管理员':

                location.assign("index.jsp");
                break;
            }

          }
          console.log(status);
        });
      });
    });


  </script>
</head>
<body style="position: absolute;top:30%;left:35%;width: 1000px;background-color: rgb(245, 235, 222);">
<div class="layui-row" style="text-align: center;">
  <div class="layui-col-md6 layui-card">
    <div class="layui-card-header layui-anim layui-anim-down" style="font-size: large;">
      用户登录
    </div>
    <div class="layui-card-body">
      <form id = "form1" class="layui-form">
        <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
        <div class="layui-form-item">
          <label class="layui-form-label">职&nbsp&nbsp&nbsp位<i
                  class="layui-icon layui-icon-friends"></i></label>
          <div class="layui-input-block">
            <select id ="employee_position" name="employee_position" lay-filter="UserPosition">
              <option value="超级管理员">超级管理员</option>
              <option value="仓库管理员">仓库管理员</option>
              <option value="仓库负责人">仓库负责人</option>
            </select>
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label" name="userName">邮&nbsp&nbsp&nbsp&nbsp箱<i class="layui-icon layui-icon-username"></i></label>

          <div class="layui-input-block">
            <input type="text" name="employee_account" id = "employee_account" class="layui-input layui-anim layui-anim-scale" >

          </div>

        </div>
        <div class="layui-form-item">


          <label class="layui-form-label">密&nbsp&nbsp&nbsp&nbsp码<i
                  class="layui-icon layui-icon-password"></i></label>
          <div class="layui-input-block">
            <input type="password" name="employee_password" id ="employee_password" class="layui-input layui-anim layui-anim-scale">
          </div>

        </div>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <button type="button" id = "loginButton" class="layui-btn" >登录</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label"><a href="">忘记密码</a></label>
        </div>
      </form>
    </div>

  </div>

</div>
</body>
</html>