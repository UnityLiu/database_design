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

    <div>
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">默认展开</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">选项1</a></dd>
                    <dd><a href="javascript:;">选项2</a></dd>
                    <dd><a href="">跳转</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">解决方案</a>
                <dl class="layui-nav-child">
                    <dd><a href="">移动模块</a></dd>
                    <dd><a href="">后台模版</a></dd>
                    <dd><a href="">电商平台</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">产品</a></li>
            <li class="layui-nav-item"><a href="">大数据</a></li>
        </ul>
    </div>
    <div>

    </div>



<%--<div style="border: 2px solid rgb(243, 214, 214);">--%>
<%--    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">--%>
<%--        <div class="layui-tab-title">--%>
<%--            <li class ="layui-this">商品库存</li>--%>
<%--            <li>员工修改记录</li>--%>
<%--            <li>仓库管理</li>--%>
<%--            <li>仓库负责人管理</li>--%>
<%--            <li>当前用户</li>--%>
<%--        </div>--%>
<%--        <div class="layui-tab-content layui-border layui-bg-gray" style = "height: 750px;">--%>
<%--            <div class="layui-tab-item layui-show">--%>
<%--                <div class="layui-panel layui-col-md10" style="position: absolute;left: 7%;">--%>
<%--                    <table id="demo" lay-filter="test"></table>--%>
<%--                    <script>--%>
<%--                        layui.use('table', function () {--%>
<%--                            var table = layui.table;--%>

<%--                            //表格实例--%>
<%--                            table.render({--%>
<%--                                elem: '#demo'--%>
<%--                                , height: 312--%>
<%--                                , url: '/' //数据接口--%>
<%--                                , page: true //开启分页--%>
<%--                                , cols: [[ //表头--%>
<%--                                    { field: 'id', title: '货单', width: 80, sort: true, fixed: 'left' }--%>
<%--                                    , { field: 'username', title: '日期', width: 80 }--%>
<%--                                    , { field: 'sex', title: '商品编号', width: 150, sort: true }--%>
<%--                                    , { field: 'city', title: '数量', width: 80 }--%>
<%--                                    , { field: 'sign', title: '经手人', width: 177 }--%>
<%--                                ]]--%>
<%--                            });--%>

<%--                        });--%>
<%--                    </script>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="layui-tab-item">--%>
<%--                <div class="layui-tab-item layui-show">--%>
<%--                    <div class="layui-panel layui-col-md10" style="position: absolute;left: 7%;">--%>

<%--                        <table id="demo01" lay-filter="test"></table>--%>
<%--                        <script>--%>
<%--                            layui.use('table', function () {--%>
<%--                                var table = layui.table;--%>

<%--                                //表格实例--%>
<%--                                table.render({--%>
<%--                                    elem: '#demo01'--%>
<%--                                    , height: 700     //高度--%>
<%--                                    , url: '/database_design_war/test/' //数据接口--%>
<%--                                    , page: true //开启分页--%>
<%--                                    ,cols: [[ //表头--%>
<%--                                        {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}--%>
<%--                                        ,{field: 'username', title: '用户名', width:80}--%>
<%--                                        ,{field: 'sex', title: '性别', width:80, sort: true}--%>
<%--                                        ,{field: 'city', title: '城市', width:80}--%>
<%--                                        ,{field: 'sign', title: '签名', width: 177}--%>
<%--                                        ,{field: 'experience', title: '积分', width: 80, sort: true}--%>
<%--                                        ,{field: 'score', title: '评分', width: 80, sort: true}--%>
<%--                                        ,{field: 'classify', title: '职业', width: 80}--%>
<%--                                        ,{field: 'wealth', title: '财富', width: 135, sort: true}--%>
<%--                                    ]]--%>
<%--                                    // , cols: [[ //表头--%>
<%--                                    //   { field: 'id', title: '货单', width: 80, sort: true, fixed: 'left' }--%>
<%--                                    //   , { field: 'username', title: '日期', width: 80 }--%>
<%--                                    //   , { field: 'sex', title: '商品编号', width: 150, sort: true }--%>
<%--                                    //   , { field: 'city', title: '数量', width: 80 }--%>
<%--                                    //   , { field: 'sign', title: '经手人', width: 177 }--%>
<%--                                    // ]]--%>
<%--                                });--%>

<%--                            });--%>
<%--                        </script>--%>





<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="layui-tab-item">--%>
<%--                <div class="layui-tab-item layui-show">--%>
<%--                    <div class="layui-panel layui-col-md10" style="position: absolute;left: 7%;">--%>
<%--                        3--%>





<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="layui-tab-item">--%>
<%--                <div class="layui-tab-item layui-show">--%>
<%--                    <div class="layui-panel layui-col-md10" style="position: absolute;left: 7%;">--%>
<%--                        4--%>







<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="layui-tab-item">--%>
<%--                <div class="layui-tab-item layui-show">--%>
<%--                    <div class="layui-panel layui-col-md10" style="position: absolute;left: 7%;">--%>
<%--                        5--%>







<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>