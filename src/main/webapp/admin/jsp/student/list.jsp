<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>
    <link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function () {
            $.get("${pageContext.request.contextPath}/student/list",function (data) {

                data.forEach(function (student, index) {

                    var str = "";
                    str += "<tr>";
                    str += "<td>"+(index+1)+"</td>";
                    str += "<td>"+student.name+"</td>";
                    str += "<td>"+student.sex+"</td>";
                    str += "<td>"+student.age+"</td>";
                    str += "<td>"+student.createTime+"</td>";
                    str += "<td>";
                    str += "<a href='${pageContext.request.contextPath}/admin/jsp/student/form.jsp?id="+student.id+"'>修改</a>";
                    str += "&emsp;";
                    str += "<a onClick='javascript:doDelete("+student.id+");'>删除</a>";
                    str += "</td>";
                    str += "</tr>";

                    $("tbody").append(str);

                });
            },"json");
        });

        function toAddPage() {
            window.location.href="${pageContext.request.contextPath}/admin/jsp/student/form.jsp";
        }

        function doDelete(id){
            if (confirm("您确定删除吗？")){
                $.get("${pageContext.request.contextPath}/student/deleteById/"+id,function (data,status) {
                    if (status == "success"){
                        alert("删除成功！");
                        window.location.href="${pageContext.request.contextPath}/admin/jsp/student/list.jsp";
                    } else {
                        alert("删除失败！");
                    }
                });

            }
        }

        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });
        });
    </script>

</head>

<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">数据表</a></li>
        <li><a href="#">基本内容</a></li>
    </ul>

    <ul class="toolbar1">
        <li onclick="toAddPage();" style="line-height:28px; height:28px;margin-top: 5px;margin-right: 8px;cursor: pointer"; >
            <span><img src="${pageContext.request.contextPath}/admin/images/t01.png" width="18" height="18" /></span>添加</li>
    </ul>
</div>

<div class="rightinfo">

 <table class="tablelist">
        <thead>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>

    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="${pageContext.request.contextPath}/admin/images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>
    </div>
</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>

