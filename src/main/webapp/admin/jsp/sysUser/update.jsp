<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">表单</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form action="${pageContext.request.contextPath}/sysUser/doUpdate" method="post">
        <input type="hidden" name="id" value="${sysUser.id}" />
        <ul class="forminfo">
            <li><label>登录名称</label><input name="loginName" type="text" class="dfinput" value="${sysUser.loginName}" /><i>登录名称只支持手机号</i></li>
            <li><label>密码</label><input name="password" type="text" class="dfinput" value="${sysUser.password}" /><i>至少包含大小写和数字</i></li>
            <li><label>真实姓名</label><input name="realName" type="text" class="dfinput" value="${sysUser.realName}"/><i>请输入真实姓名</i></li>
            <li><label>性别</label><select name="sex" class="dfinput">
                <option value="0"${sysUser.sex==0?"checked":""}>男</option>
                <option value="1"${sysUser.sex==1?"checked":""}>女</option>
            </select><i>请选择性别</i></li>
            <li><label>手机号码</label><input name="tel" type="text" class="dfinput" value="${sysUser.tel}"/><i>请输入手机号码</i></li>
            <li><label>角色信息</label>
                <c:forEach items="${sysRoleList}" var="sysRole">
                    <input type="radio" value="${sysRole.id}"${sysRole.id==sysUser.roleId?"checked='checked'":""} name="roleId"/>${sysRole.name}
                </c:forEach>
                <i>请选择</i>
            </li>

            <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存" /></li>
        </ul>
    </form>
    <!--
        <ul class="forminfo">
        <li><label>文章标题</label><input name="" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
        <li><label>关键字</label><input name="" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
        <li><label>是否审核</label><cite><input name="" type="radio" value="" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input name="" type="radio" value="" />否</cite></li>
        <li><label>引用地址</label><input name="" type="text" class="dfinput" value="http://www..com/html/uidesign/" /></li>
        <li><label>文章内容</label><textarea name="" cols="" rows="" class="textinput"></textarea></li>
        <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存"/></li>
    </ul>
    -->



</div>
</body>
</html>
