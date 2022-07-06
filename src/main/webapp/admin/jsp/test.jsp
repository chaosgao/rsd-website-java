<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Title</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-3.6.0.js"></script>
        <script type="text/javascript">
            $(function() {
                document.getElementById("fk").innerText="BBB";
                $("p").val("456");
                $("#fk").html("上海");
                $(".aa").css("color","red");
                // $("#AA").click(function () {
                //     alert("aaa")
                // });
                $("#AA").click(function () {
                    $("[name='BB']").val("aaaaaaaaaaaaaa")
                })
                $(":button.name").bind("click",null,function () {
                    alert("BBBBB")
                })

            });

            function fromSubmit() {
                var loginName = document.getElementsByName("loginName");
                if (loginName[0].value == ""){
                    alert("名称不可为空!");
                    return false;
                }
                if (loginName[1].value == ""){
                    alert("密码不可为空!");
                    return false;
                }
                return true;

            }
        </script>
    </head>
    <body>
    <div class="aa" id="fk"></div>
    <p>123456</p>
    <input type="text" id="name" name="BB" value="oo">
    <input type="button" class="name"  value="点啊">
    <input id="AA" type="button" value="点击" />
    <form action="/aa/bb" method="get" onsubmit="return fromSubmit();">
        <input type="text" name="loginName" />
        <input type="text" name="loginName" />
        <input type="submit" />
    </form>
    </body>
</html>
