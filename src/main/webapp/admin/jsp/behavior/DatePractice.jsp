<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/My97DatePicker/WdatePicker.js" ></script>
    <script type="text/javascript">
        $(function(){

            // 日期验证
            $(":submit").click(function(){
                if($("input[name=datetime]").val() == ""){
                    alert("日期为空！");
                    return false;
                }else{
                    alert($("input[name=datetime]").val());
                }
            });


        });

    </script>
</head>
<body>
<form action="" method="post">
    <table border="0" cellspacing="0">
        <tr>
            <td>出生日期：</td>
            <td><input type="text" class="Wdate" name="datetime" id="" value="" onfocus="WdatePicker({lang:'zh-cn',readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td>
        </tr>
        <tr>
            <td>出生日期：</td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>