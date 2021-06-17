<%--
  Created by IntelliJ IDEA.
  User: unityliu
  Date: 2021/5/27
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!-- 超级管理员 -->

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>超级管理员</title>

  <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/layui/css/layui.css">

  <script>
    layui.layui.use(['element'], function(){
      var element = layui.element;
    });
  </script>
</head>
<body style="background-color: rgb(245, 235, 222);">
<!-- <ul class="layui-nav">
  <li class="layui-nav-item"><a href="">商品库存</a></li>
  <li class="layui-nav-item"><a href="">员工修改记录</a></li>
  <li class="layui-nav-item"><a href="">仓库管理</a></li>
  <li class="layui-nav-item"><a href="">仓库负责人管理</a></li>
</ul> -->
<div style="margin:  0% 20% 0% 20%;height: 10%;width: 60%;background: #00F7DE;position: relative">
  <div style="position: absolute;top: 40px;right: 40px">
    <i class="layui-icon layui-icon-friends"></i>您好：超级管理员
    <a>退出</a>
  </div>
</div>

<div style="margin:  0% 20% 0% 20%;height: 90%;width: 60%;background: #74c177">
  <div style="border: 2px solid rgb(243, 214, 214);">
    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
      <div class="layui-tab-title">
        <li class ="layui-this">仓库物品修改记录</li>
        <li>仓库物品管理</li>
        <li>员工管理</li>
        <li>个人中心</li>
      </div>
      <div class="layui-tab-content layui-border layui-bg-gray" style = "height: 750px;">
        <div class="layui-tab-item layui-show">
          <div class="layui-panel layui-col-md10" style="margin: 1% 2% 0% 2%;width: 96%;height: 100%">
            <table id="demo01" lay-filter="test">
            </table>
            <script>
              layui.use('table', function () {
                var table = layui.table;
                //表格实例
                table.render({
                  elem: '#demo01'
                  , height: 312
                  , url: '/' //数据接口
                  , page: true //开启分页
                  , cols: [[ //表头
                    { field: 'id', title: '商品编号', width: 150, sort: true, fixed: 'left' }
                    , { field: 'username', title: '商品名称', width: 150 , sort: true}
                    , { field: 'sex', title: '商品种类', width: 150, sort: true }
                    , { field: 'city', title: '进货量', width: 120 , sort: true}
                    , { field: 'sign', title: '出货量', width: 120 , sort: true}
                    , { field: 'username', title: '报废量', width: 150 , sort: true}
                    , { field: 'sex', title: '核实保费量', width: 120 , sort: true}
                    , { field: 'city', title: '实际储量', width: 150 , sort: true}
                  ]]
                });

              });
            </script>
          </div>
        </div>
        <div class="layui-tab-item">
          <div class="layui-tab-item layui-show">
            <div class="layui-panel layui-col-md10" style="margin: 1% 2% 0% 2%;width: 96%;height: 100%">

              <table id="demo02" lay-filter="test"></table>
              <script>
                layui.use('table', function () {
                  var table = layui.table;

                  //表格实例
                  table.render({
                    elem: '#demo02'
                    , height: 700     //高度
                    , url: '/database_design_war/test/' //数据接口
                    , page: true //开启分页
                    ,cols: [[ //表头
                      {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                      ,{field: 'username', title: '用户名', width:80}
                      ,{field: 'sex', title: '性别', width:80, sort: true}
                      ,{field: 'city', title: '城市', width:80}
                      ,{field: 'sign', title: '签名', width: 177}
                      ,{field: 'experience', title: '积分', width: 80, sort: true}
                      ,{field: 'score', title: '评分', width: 80, sort: true}
                      ,{field: 'classify', title: '职业', width: 80}
                      ,{field: 'wealth', title: '财富', width: 135, sort: true}
                    ]]
                    // , cols: [[ //表头
                    //   { field: 'id', title: '货单', width: 80, sort: true, fixed: 'left' }
                    //   , { field: 'username', title: '日期', width: 80 }
                    //   , { field: 'sex', title: '商品编号', width: 150, sort: true }
                    //   , { field: 'city', title: '数量', width: 80 }
                    //   , { field: 'sign', title: '经手人', width: 177 }
                    // ]]
                  });

                });
              </script>
            </div>
          </div>
        </div>

        <div class="layui-tab-item">
          <div class="layui-tab-item layui-show">
            <div class="layui-panel layui-col-md10" style="margin: 1% 2% 0% 2%;width: 96%;height: 100%">
              <table id="demo03" lay-filter="test"></table>
              <script>
                layui.use('table', function () {
                  var table = layui.table;

                  //表格实例
                  table.render({
                    elem: '#demo03'
                    , height: 700     //高度
                    , url: '${pageContext.request.contextPath}/getAllEmployeesByJson' //数据接口
                    , page: true //开启分页
                    ,cols: [[ //表头
                      {field:  'warehouse_id', title: '仓库编号', width:150, sort: true, fixed: 'center'}
                      ,{field: 'employee_account', title: '账户名', width:170,sort: true}
                      ,{field: 'employee_name', title: '姓名', width:150,sort: true}
                      ,{field: 'employee_gender', title: '性别', width:150, sort: true}
                      ,{field: 'employee_born_date', title: '出生日期', width:180,sort: true}
                      ,{field: 'employee_position', title: '职位', width: 177,sort: true}
                      ,{field: 'employee_salary', title: '薪水', width: 150, sort: true}
                    ]]
                    // , cols: [[ //表头
                    //   { field: 'id', title: '货单', width: 80, sort: true, fixed: 'left' }
                    //   , { field: 'username', title: '日期', width: 80 }
                    //   , { field: 'sex', title: '商品编号', width: 150, sort: true }
                    //   , { field: 'city', title: '数量', width: 80 }
                    //   , { field: 'sign', title: '经手人', width: 177 }
                    // ]]
                  });

                });
              </script>
            </div>
          </div>
        </div>
        <div class="layui-tab-item">
          <div class="layui-tab-item layui-show">
            <div class="layui-panel layui-col-md10" style="margin: 1% 2% 0% 2%;width: 96%;height: 100%">

            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</div>



</body>
</html>





<%--<html>--%>
<%--<body>--%>
<%--    <h2>Hello World!</h2>--%>
<%--    <%--%>
<%--        request.getRequestDispatcher("/login.jsp").forward(request,response);--%>
<%--        //重定向到登录页面--%>

<%--    %>--%>

<%--</body>--%>
<%--</html>--%>




