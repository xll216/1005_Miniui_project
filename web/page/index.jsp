<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <link href="css/demo.css" rel="stylesheet" type="text/css"/>

    <script src="../scripts/boot.js" type="text/javascript"></script>

    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            border: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
        }

        .header {
            background: url(img/header.gif) repeat-x 0 -1px;
        }

    </style>
</head>
<body>

<div id="layout1" class="mini-layout" style="width:100%;height:100%;">
    <div class="header" region="north" height="70" showSplit="false" showHeader="false">
        <h1 style="margin:0;padding:15px;cursor:default;font-family:'Trebuchet MS',Arial,sans-serif;">采购监管平台系统</h1>
    </div>
    <div title="south" region="south" showSplit="false" showHeader="false" height="30">
        <div style="line-height:28px;text-align:center;cursor:default">Copyright © 蓝鸥科技有限公司版权所有</div>
    </div>
    <div showHeader="false" region="west" width="180" maxWidth="250" minWidth="100">
        <!--OutlookMenu-->
        <div id="leftTree" class="mini-outlookmenu"
             url="/page/data/menu.txt"
             onitemselect="onItemSelect"
             idField="id" parentField="pid"
             textField="text"
             borderStyle="border:0">
        </div>

    </div>
    <div title="center" region="center" bodyStyle="overflow:hidden;">
        <iframe id="mainframe" frameborder="0" name="main" style="width:100%;height:100%;" border="0"></iframe>
    </div>
</div>


<script type="text/javascript">
    mini.parse();

    //init iframe src
    var iframe = document.getElementById("mainframe");
    iframe.src = "/page/home.jsp";

    function onItemSelect(e) {
        var item = e.item;
        iframe.src = item.url;
    }
</script>

</body>
</html>