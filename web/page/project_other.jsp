<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>其他</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <link href="css/demo.css" rel="stylesheet" type="text/css"/>

    <script src="../scripts/boot.js" type="text/javascript"></script>
    <script src="js/jquery.cookie.js" type="text/javascript"></script>
    <script src="js/ajaxfileupload.js" type="text/javascript"></script>
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

        #cbl1 {
            display: inline-flex;
        }


    </style>

</head>
<body>


<div id="form2">

    <input name="id" class="mini-hidden"/>
    <table width="100%">
        <tr class="header">
            <td colspan="2">附件信息</td>
        </tr>
        <tr>
            <td class="lefttd">立项报告书</td>
            <td class="righttd" id="upload">
                <input class="mini-htmlfile" name="Fdata"
                       id="file1" style="width:100%;"/>
                <%--两个隐藏组件包含两个表单中的数据--%>
                <input id="base" type="hidden" name="base">
                <input id="other" type="hidden" name="other">
            </td>
        </tr>
        <tr>
            <td class="lefttd">审批(部门经理)</td>
            <td class="righttd">
                <input id="studentSel" class="mini-buttonedit"
                       style="width:100%;height:100%;"
                       allowInput="false"
                       onbuttonclick="onStudentButtonEdit" name="sid" textName="sname"/>
            </td>
        </tr>

        <!--产品信息...-->
        <tr>
            <td colspan="4" class="header">产品信息</td>
        </tr>
        <tr>
            <td class="header">产品形式</td>
            <td class="td2" style="background: white">
                <div id="cbl1" style="width:100%;"
                     name="projType"
                     class="mini-checkboxlist"
                     value="cb01,cb03"
                     textField="text" valueField="id">
                </div>
            </td>
        </tr>

        <tr class="header">
            <td colspan="2">技术第一负责人</td>
        </tr>
        <tr>
            <td class="lefttd">能力简介</td>
            <td>
                <textarea class="mini-textarea" style="width:100%;height:100%;"
                          emptyText="请输入能力简介"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="background-color: white;text-align: right">
                <a class="mini-button" onclick="submitForm()">提交</a>
            </td>
        </tr>
    </table>


</div>
<script type="text/javascript">
    mini.parse();

    var cbl1 = mini.get("cbl1");
    var arr = [
        {"id": "cb01", "text": "专题报告"},
        {"id": "cb02", "text": "技术方案"},
        {"id": "cb03", "text": "技术标准"},
        {"id": "cb04", "text": "硬件产品"},
        {"id": "cb05", "text": "生产性文件"},
        {"id": "cb06", "text": "设计文件"},
        {"id": "cb07", "text": "计算机软件"},
        {"id": "cb08", "text": "其他"}
    ];
    cbl1.setData(arr);

    $("#cbl1").append(
        "<input type='text' name='oth' " +
        "value='默认值' disabled='disabled'>")

    function getForm() {
        var form = new mini.Form("#form2");
        var data = form.getData();
        var s = mini.encode(data);
        return s;
    }

    /*点击提交按钮触发的事件*/
    function submitForm() {
        /*1.获得基本信息tab表单中的数据 cookies取*/
        var base = $.cookie("form1");

        /*2.获得当前其他信息tab表单中的数据 直接获取当前表单*/
        var other = getForm();

        console.log(base + "--" + other);

        /*3.将数据传递给后台*/
        /*3.1 给两个隐藏input设置数据*/
        $("#base").val(base);
        $("#other").val(other);

        /*3.2 通过ajax上传文件、数据*/
        $.ajaxFileUpload({
            url: "fileUpload.action",
            fileElementId: $("#upload"), /*文件上传的id域*/
            success: function (data) {
                console.log(data);
            }
        })

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