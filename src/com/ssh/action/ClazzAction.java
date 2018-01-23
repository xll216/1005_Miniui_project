package com.ssh.action;

import com.ssh.domain.Clazz;
import com.ssh.page.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
@Scope("prototype")
public class ClazzAction extends BaseAction<Clazz> {
    private Clazz clazz;

    /**
     * 搜索班级列表
     **/
    public String searchClazz() {
        System.out.println(clazz);


        PageBean<Clazz> pageBean = clazzService.searchClazz(clazz,
                getPageIndex() + 1, getPageSize());

        baseResult = new BaseResult<>();

        baseResult.setTotal(pageBean.getTotalRecord());
        baseResult.setData(pageBean.getBeanList());

        return SUCCESS;
    }

    @Override
    public Clazz getModel() {
        clazz = new Clazz();
        return clazz;
    }
}
