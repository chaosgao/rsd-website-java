<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title>ztree树</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/admin/js/zTree/css/zTreeStyle/zTreeStyle.css" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/zTree/js/jquery.ztree.all.js"></script>

    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/admin/js/My97DatePicker/WdatePicker.js"></script>

    <SCRIPT type="text/javascript">
        var setting = {
                check:{
                  enable: true
                },
            view: {
                dblClickExpand: false,
                showLine: true,
                selectedMulti: false
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "fatherId",
                    rootPId: ""
                }
            },
            callback: {
                beforeClick: function (treeId, treeNode) {
                    var zTree = $.fn.zTree.getZTreeObj("tree");
                    if (treeNode.isParent) {
                        zTree.expandNode(treeNode);
                        return false;
                    } else {
                        demoIframe.attr("src", treeNode.file + ".html");
                        return true;
                    }
                }
            }
        };
        $(document).ready(function () {
            $.get("${pageContext.request.contextPath}/behavior/list", function (data) {
                var zNodes = new Array();
                for (var i = 0; i < data.length; i ++) {
                    var behavior = {
                        id:data[i].id,
                        fatherId:data[i].fatherId,
                        name:data[i].name,
                        open:false,
                        file:""
                    };
                    zNodes.push(behavior);
                }
                $.fn.zTree.init($("#tree"), setting, zNodes);
            });

            $("[type='button']").bind("click",function () {
                var leafNodes = new Array();

                var treeObj = $.fn.zTree.getZTreeObj("tree");
                var nodes = treeObj.getCheckedNodes(true);

                $.map(nodes,function (row) {
                    if (!row.isParent){
                        alert(JSON.stringify(row));
                    }

                })
            })
        });
    </SCRIPT>
</head>

<body>
<div id="tree" class="ztree" style="width:260px; overflow:auto;"></div>
<input type="button" value="点击显示" />
</body>
</html>