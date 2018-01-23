package com.ssh.action;

import com.ssh.domain.Student;
import com.ssh.page.PageBean;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@Scope("prototype")
public class StudentAction extends BaseAction<Student> {
    private Student student;

    /**
     * 搜索学生列表
     **/
    public String searchStudent() {
        baseResult = new BaseResult<>();

        PageBean<Student> pageBean = studentService.searchStudent(student,
                getPageIndex() + 1, getPageSize());

        baseResult.setData(pageBean.getBeanList());
        baseResult.setTotal(pageBean.getTotalRecord());

        return SUCCESS;
    }


    /**
     * 文件上传
     **/
    private File Fdata;//上传的文件对象
    private String FdataContentType;//上传的文件类型
    private String FdataFileName;//上传的文件名称

    private String base;//基本信息
    private String other;//其他信息

    public String fileUpload() throws IOException {

        /*文件保存*/
        saveFile();


        return SUCCESS;
    }

    /**
     * 文件保存
     **/
    private void saveFile() {
        if (Fdata == null) {
            return;
        }

        /*取项目的发布路径*/
        String root = ServletActionContext
                .getServletContext()
                .getRealPath("files");

        File parent = new File(root);

        if (!parent.exists() || !parent.isDirectory()) {
            parent.mkdirs();
        }

        /*要保存的目的文件*/
        File destFile = new File(
                parent, FdataFileName);

        try {
            /*文件拷贝*/
            FileUtils.copyFile(Fdata, destFile);

            System.out.println("文件保存成功："
                    + destFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public File getFdata() {
        return Fdata;
    }

    public void setFdata(File fdata) {
        Fdata = fdata;
    }

    public String getFdataContentType() {
        return FdataContentType;
    }

    public void setFdataContentType(String fdataContentType) {
        FdataContentType = fdataContentType;
    }

    public String getFdataFileName() {
        return FdataFileName;
    }

    public void setFdataFileName(String fdataFileName) {
        FdataFileName = fdataFileName;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public Student getModel() {
        student = new Student();
        return student;
    }
}
