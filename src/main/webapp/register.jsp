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
    <title>用户注册</title>
    <!-- 链接到layui框架 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/layui/css/layui.css">
    <style>
        #text {
            color: red;
        }
    </style>
    <script src = "${pageContext.request.contextPath}/static/lib/layui/layui.js"></script>
    <script src = "${pageContext.request.contextPath}/static/lib/jquery-3.6.0.js"></script>
    <script language="JavaScript">

        layui.use('laydate', function(){
            // 执行一个laydate实例
            let laydate = layui.laydate;
            laydate.render({
                elem: '#ageDate', //指定元素
                value:'2001-01-01',
                position:'fixed'
            });
        });

        function loginDispatcher(){
            location.assign("login.jsp");
        }
        function checkPassword(){
            let password01 = document.getElementById("userPassword").value;
            let password02 = document.getElementById("userPassword01").value;
            if(password01 == password02){
                return true;
            }else{
                return false;
            }
        }


        //异步发送验证码
        $(document).ready(function (){
            //选择“获取验证码“按钮
            $("#getVercodeBtn").click(function (){
                let emailUrl = $("#EmailArea").val();
                let getUrl = "${pageContext.request.contextPath}/getCode";
                $.get(
                    getUrl,
                    {
                        "sendEmail":emailUrl
                    },
                    function (data,status){
                        if(data == "true"){
                            alert("验证码发送成功");
                            layui.use('util', function(){
                                var util = layui.util;

                                //示例
                                var endTime = new Date().setSeconds(new Date().getSeconds()+60) //假设为结束日期
                                    ,serverTime = new Date().getTime(); //假设为当前服务器时间，这里采用的是本地时间，实际使用一般是取服务端的

                                util.countdown(endTime, serverTime, function(date, serverTime, timer){
                                    var str = date[3];
                                    layui.$('#countDown').html(str);
                                    layui.$('#getVercodeBtn').attr("disabled","disabled");
                                });
                            });
                        }else{
                            //验证码发送失败
                        }
                    }
                );
            });
        });


        //异步提交表单
        $(document).ready(function (){
            $("#subBtn").click(function (){
                //验证验证码正确性
                let verCode = $("#verCode").val();
                $.post(
                    "${pageContext.request.contextPath}/getCode",
                    {
                        "verCode":verCode
                    },
                    function (data,status){
                        if(data == "false"){
                            alert("验证码错误");
                        }else{
                            //提交注册表单
                            let postUrl = "${pageContext.request.contextPath}/register";
                            $.post(
                                postUrl,
                                $("#mainForm").serialize(),
                                function (data,status){
                                    if(data == "true"){
                                        alert("注册成功");
                                    }else{
                                        alert("注册失败");
                                    }
                                }
                            );
                        }
                    }
                );


            });
        });


        <%--$(document).ready(function (){--%>
        <%--    $("#subBtn").click(function (){--%>
        <%--        let postUrl = "${pageContext.request.contextPath}/register";--%>
        <%--        $.get(--%>
        <%--            postUrl,--%>
        <%--            $("#mainForm").serialize(),--%>
        <%--            function (data,status){--%>
        <%--                if(data == "true"){--%>
        <%--                    alert("注册成功");--%>
        <%--                }else{--%>
        <%--                    alert("注册失败");--%>
        <%--                }--%>
        <%--            }--%>
        <%--        );--%>
        <%--    });--%>
        <%--});--%>
        //提交注册表单


        // layui.use('util', function(){
        //     var util = layui.util;
        //
        //     //示例
        //     var endTime = new Date().setSeconds(new Date().getSeconds()+60) //假设为结束日期
        //         ,serverTime = new Date().getTime(); //假设为当前服务器时间，这里采用的是本地时间，实际使用一般是取服务端的
        //
        //     util.countdown(endTime, serverTime, function(date, serverTime, timer){
        //         var str = date[3];
        //         layui.$('#countDown').html(str);
        //         layui.$('#getVercodeBtn').attr("disabled","disabled");
        //     });
        // });


    </script>
</head>

<body style="position: absolute;top:15%;left:35%;width: 1000px;background-color: rgb(245, 235, 222);">



<div class="layui-row" style="text-align: center;">
    <div class="layui-col-md6 layui-card">
        <div class="layui-card-header layui-anim layui-anim-down" style="font-size: large;">
            用户注册
            
        </div>
        <div class="layui-card-body">
            <form id = "mainForm" class="layui-form">
                <div class="layui-form-item">
                    <label class="layui-form-label">姓&nbsp&nbsp&nbsp&nbsp名<i class="layui-icon layui-icon-face-smile-fine"></i></label>
                    <div class="layui-input-block">
                        <input type="text" id = "userTheName" name="userTheName" class="layui-input layui-anim layui-anim-scale">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性&nbsp&nbsp&nbsp&nbsp别<i class="layui-icon layui-icon-male"></i></label>
                    <div class="layui-input-block">
                        <input type="radio" name="userSex" value="man" title="男">
                        <input type="radio" name="userSex" value="woman" title="女" checked>
                        <input type="radio" name="userSex" value="" title="中性" disabled>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">出生日期<i class="layui-icon layui-icon-time"></i></label>
                    <div class="layui-input-block">
                        <input type="text" name="bornDate" class="layui-input" id="ageDate" placeholder="yyyy年MM月dd日">
                    </div>
                </div>
                <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">职&nbsp&nbsp&nbsp&nbsp位<i class="layui-icon layui-icon-friends"></i></label>
                    <div class="layui-input-block">

                        <select name="position" lay-filter="aihao">
                            <option value="super_administrator">超级管理员</option>
                            <option value="warehouse_administrator">仓库管理员</option>
                            <option value="warehouse-header">仓库负责人</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" name="userName">邮&nbsp&nbsp&nbsp&nbsp箱<i class="layui-icon layui-icon-email"></i></label>
                    <div class="layui-input-block">
                        <input type="text" name="userName" id = "EmailArea" lay-verify="email" autocomplete="off" class="layui-input layui-anim layui-anim-scale">
                    </div>

                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">验证码<i class="layui-icon layui-icon-vercode"></i></label>
                    <div class="layui-input-inline">
                        <input type="text" id = "verCode" name="vercode" class="layui-input layui-anim layui-anim-scale">
                    </div>
                    <button type="button" id = "getVercodeBtn" class="layui-btn layui-btn-primary" >获取验证码</button>
                    <span id = "countDown"></span>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">密&nbsp&nbsp&nbsp&nbsp码<i class="layui-icon layui-icon-password"></i></label>
                    <div class="layui-input-block">
                        <input type="password" id = "userPassword" name="userPassword" class="layui-input layui-anim layui-anim-scale">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">再次输入<i class="layui-icon layui-icon-password"></i></label>
                    <div class="layui-input-block">
                        <input type="password" id = "userPassword01" name="password02" class="layui-input layui-anim layui-anim-scale" onkeyup="checkPassword()">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="button" id = "subBtn" class="layui-btn">注册</button>
                        <button type="button" class="layui-btn" onclick="loginDispatcher()">前往登录</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>

    </div>

</div>
</body>

</html>