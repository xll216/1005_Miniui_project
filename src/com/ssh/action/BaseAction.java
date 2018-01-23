package com.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.service.ClazzService;
import com.ssh.service.StudentService;

import javax.annotation.Resource;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public abstract class BaseAction<T>
        extends ActionSupport
        implements ModelDriven<T> {

    @Resource
    protected StudentService studentService;
    @Resource
    protected ClazzService clazzService;

    protected BaseResult<T> baseResult;
    private int pageIndex;
    private int pageSize;
    private String[] sortField;
    private String[] sortOrder;

    public BaseResult<T> getBaseResult() {
        return baseResult;
    }

    public void setBaseResult(BaseResult<T> baseResult) {
        this.baseResult = baseResult;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String[] getSortField() {
        return sortField;
    }

    public void setSortField(String[] sortField) {
        this.sortField = sortField;
    }

    public String[] getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String[] sortOrder) {
        this.sortOrder = sortOrder;
    }
}
