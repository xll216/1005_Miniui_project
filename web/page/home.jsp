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
    <script src="js/jquery.cookie.js" type="text/javascript"></script>
</head>
<body>

<div id="tabs1" class="mini-tabs"
     activeIndex="0"
     style="width:100%;height:100%;"
     url="/page/data/tabs.txt"
     onactivechanged="onActiveChanged">
</div>


<script type="text/javascript">
    mini.parse();

    /*先找到tab组件*/
    var tabs = mini.get("tabs1");
    /*给tab组件加入监听事件,tab切换前的事件回调*/
    tabs.on("beforeactivechanged", function (e) {

        /*控件加入DOM元素呈现*/
        var tabs = e.sender;
        /*取第一个tab页面的iframe对象*/
        var iframe = tabs.getTabIFrameEl(
            tabs.getTab(0));

        /*将第一个tab页面中的数据保存到cookie中*/
        var data = iframe.contentWindow.getForm();

        /*将第一个form表单中的数据保存到cookie中
         * cookie存储的key为form1*/
        $.cookie("form1", data);

        console.log("第一个表单的数据：" + data);
    });

    /////////////////////////////
    function onActiveChanged(e) {
        var tabs = e.sender;
        var tab = e.tab;
        if (!tab) return;

        if (tabs.getTabIFrameEl(tab)) return;  //已经存在iframe，则返回
        var url = tab.url + "?id=" + 1; //加工url，传递更多参数
        tabs.loadTab(url, tab);
    }

</script>
</body>
</html>
