<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>基本</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <link href="css/demo.css" rel="stylesheet" type="text/css"/>

    <script src="../scripts/boot.js" type="text/javascript"></script>
    <style>
        table, td {
            border: 2px solid white;
            border-collapse: collapse;
            font-size: 15px;
            padding: 10px;
            background-color: #ebeef5;
        }

        .header {
            background-color: #f4f6f9;
            font-family: "Trebuchet MS";
            Arial: "sans-serif";
        }

        .lefttd {
            width: 80px;
            text-align: right;
        }

        .righttd {
            padding: 2px;
        }
    </style>

</head>
<body>


<div id="form1">

    <input name="id" class="mini-hidden"/>
    <table width="100%">
        <tr class="header">
            <td colspan="2">项目名称</td>
        </tr>
        <tr>
            <td class="lefttd">班级选择</td>
            <td class="righttd">
                <input id="clazzSel" class="mini-buttonedit"
                       style="width:100%;height:100%;"
                       allowInput="false"
                       onbuttonclick="onClazzButtonEdit"
                       name="cid" textName="cname"/>
            </td>
        </tr>
        <tr>
            <td class="lefttd">学生选择</td>
            <td class="righttd">
                <input id="studentSel" class="mini-buttonedit"
                       style="width:100%;height:100%;"
                       allowInput="false"
                       onbuttonclick="onStudentButtonEdit"
                       name="sid" textName="sname"/>
            </td>
        </tr>
        <tr class="header">
            <td colspan="2">产品描述</td>
        </tr>
        <tr>
            <td class="lefttd">产品形式</td>
            <td></td>
        </tr>
    </table>


</div>
<script type="text/javascript">
    mini.parse();

    /*返回表单数据*/
    function getForm() {
        var form = new mini.Form("#form1");
        var data = form.getData();
        var s = mini.encode(data);
        return s;
    }


    function onClazzButtonEdit(e) {
        var btnEdit = this;
        mini.open({
            url: "/page/select_clazz_gridwindow.jsp",
            title: "选择班级列表",
            width: '80%',
            height: '80%',
            showMaxButton: true,
            ondestroy: function (action) {
                if (action == "ok") {
                    var iframe = this.getIFrameEl();
                    var data = iframe.contentWindow.GetData();
                    data = mini.clone(data);    //必须
                    if (data) {
                        console.log(data.cid + "--" + data.cname);
                        btnEdit.setValue(data.cid);
                        btnEdit.setText(data.cname);
                    }
                }
            }
        });

    }
    function onStudentButtonEdit(e) {
        var btnEdit = this;
        mini.open({
            url: "/page/select_student_gridwindow.jsp",
            title: "选择学生列表",
            width: '80%',
            height: '80%',
            showMaxButton: true,
            ondestroy: function (action) {
                if (action == "ok") {
                    var iframe = this.getIFrameEl();
                    var data = iframe.contentWindow.GetData();
                    data = mini.clone(data);    //必须
                    if (data) {
                        console.log(data.sid + "--" + data.sname);
                        btnEdit.setValue(data.sid);
                        btnEdit.setText(data.sname);
                    }
                }
            }
        });

    }

</script>


</body>

</html>