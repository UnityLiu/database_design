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
    <title>仓库管理员</title>

    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/static/lib/jquery-3.6.0.js"></script>
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
    <div style="position: absolute;left: 40px;font-size: 65px">
        a1仓库
    </div>
    <div style="position: absolute;top: 40px;right: 40px">
        <i class="layui-icon layui-icon-friends"></i>您好：仓库管理员
        <a>退出</a>
    </div>
</div>

<div style="margin:  0% 20% 0% 20%;height: 90%;width: 60%;background: #74c177">
    <div style="border: 2px solid rgb(243, 214, 214);">
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <div class="layui-tab-title">
                <li class ="layui-this">进货</li>
                <li>出货</li>
                <li>查看商品</li>
                <li>个人中心</li>
            </div>
            <div class="layui-tab-content layui-border layui-bg-gray" style = "height: 750px;">
                <div class="layui-tab-item layui-show">
                    <div class="layui-panel layui-col-md10" style="margin: 1% 2% 0% 2%;width: 96%;height: 100%">
                        <table class="layui-table" id = "demo01" lay-filter="demo01">

                        </table>
                        <script>
                            layui.use(['table','util'], function () {
                                var table = layui.table, util = layui.util;
                                //表格实例
                                table.render({
                                    elem: '#demo01'
                                    , height: 'full'
                                    , url: '${pageContext.request.contextPath}/getAllGoodsByJson' //数据接口
                                    , loading:true
                                    , page: true //开启分页
                                    , cols: [[ //表头
                                        { field: 'goods_id', title: '商品编号',  sort: true, fixed: 'left' }
                                        , { field: 'goods_name', title: '商品名称', sort: true}
                                        , { field: 'goods_kind', title: '商品种类', sort: true }
                                        , { field: 'goods_inventory', title: '库存量',  sort: true}
                                        , { field: 'goods_purchase_price', title: '单价',  sort: true}
                                        , { field: 'right',align: 'center', toolbar: '#barDemo'}
                                    ]]
                                });

                                table.on('tool(demo01)',function (obj){
                                    var data = obj.data;
                                    if(obj.event === 'edit'){
                                        // alert(JSON.stringify(data));
                                        // alert(data.goods_id);
                                        layer.open({
                                            type:1
                                            ,area: ['300px', '200px']
                                            ,content:
                                                '<form class="layui-form" style="margin-top: 10px;width: 280px">' +
                                                '<div class = "layui-form-item">' +
                                                    '<label class="layui-form-label">进货数量：</label>' +
                                                    '<div class="layui-input-block">' +
                                                        '<input id = "inNumber" type="text" name="inNumber" required  lay-verify="required" placeholder="请输入数量" autocomplete="off" class="layui-input">' +
                                                        '' +
                                                        '' +
                                                        '' +
                                                        '' +
                                                        '' +
                                                    '</div>' +
                                                '</div>'
                                            ,title:'进货'
                                            ,btn:['提交','关闭']
                                            ,yes:function (index, layero){

                                                $.post('url',{
                                                    'goods_id':data.goods_id,
                                                    'in_goods_number':$("#inNumber").val()

                                                },function (data,status){
                                                    alert(data);
                                                });

                                                //要写个ajax提交商品编号以及进货数量


                                                alert(data.goods_id);
                                                alert($("#inNumber").val());

                                            }
                                            ,btn2:function (index, layero){
                                                layer.closeAll();
                                            }

                                        });

                                    }
                                });
                            });
                        </script>
                        <script type="text/html" id = "barDemo">
                            <a class="layui-btn layui-btn-sm" lay-event="edit">进货</a>
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
                                        , height: 'full'
                                        , url: '${pageContext.request.contextPath}/getAllGoodsByJson' //数据接口
                                        , page: true //开启分页
                                        , cols: [[ //表头
                                            { field: 'goods_id', title: '商品编号', width: 150, sort: true, fixed: 'left' }
                                            , { field: 'goods_name', title: '商品名称', width: 150 , sort: true}
                                            , { field: 'goods_supplier', title: '供货商', width: 150 , sort: true}
                                            , { field: 'goods_kind', title: '商品种类', width: 150, sort: true }
                                            , { field: 'goods_inventory', title: '库存量', width: 120 , sort: true}
                                            , { field: 'goods_selling_price', title: '售价', width: 120 , sort: true}
                                        ]]
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
                                        , height: 'full'     //高度
                                        , url: '${pageContext.request.contextPath}/getAllGoodsByJson' //数据接口
                                        , page: true //开启分页
                                        , loading:true
                                        ,cols: [[ //表头
                                            {field: 'goods_id', title: '商品编号', width:80, sort: true, fixed: 'left'}
                                            ,{field: 'goods_name', title: '商品名称', width:80}
                                            ,{field: 'warehouse_id', title: '仓库编号', width:80, sort: true}
                                            ,{field: 'goods_supplier', title: '供货商', width:80}
                                            ,{field: 'goods_kind', title: '品类', width: 177}
                                            ,{field: 'goods_purchase_price', title: '进价', width: 80, sort: true}
                                            ,{field: 'goods_selling_price', title: '售价', width: 80, sort: true}
                                            ,{field: 'goods_inventory', title: '库存量', width: 80}
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




