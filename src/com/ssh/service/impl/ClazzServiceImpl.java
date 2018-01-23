package com.ssh.service.impl;

import com.ssh.dao.ClazzDao;
import com.ssh.domain.Clazz;
import com.ssh.page.PageBean;
import com.ssh.service.ClazzService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Service("clazzService")
public class ClazzServiceImpl implements ClazzService {
    @Resource
    private ClazzDao clazzDao;

    @Override
    public List<Clazz> searchClazz(Clazz clazz) {
        String hql = "from Clazz where 1=1 ";
        Object[] args;

        List<Object> params = new ArrayList<>();
        if (!StringUtils.isBlank(clazz.getCname())) {
            hql += " and cname like ?";
            params.add("%" + clazz.getCname() + "%");
        }

        if (!StringUtils.isBlank(clazz.getCinfor())) {
            hql += " and cinfor like ?";
            params.add("%" + clazz.getCinfor() + "%");
        }


        args = params.toArray();

        return clazzDao.selectAll(hql, args);
    }

    @Override
    public PageBean<Clazz> searchClazz(Clazz clazz, int pageNum, int pageSize) {

        String hql = "from Clazz where 1=1 ";
        Object[] args;

        List<Object> params = new ArrayList<>();
        if (!StringUtils.isBlank(clazz.getCname())) {
            hql += " and cname like ?";
            params.add("%" + clazz.getCname() + "%");
        }

        if (!StringUtils.isBlank(clazz.getCinfor())) {
            hql += " and cinfor like ?";
            params.add("%" + clazz.getCinfor() + "%");
        }

        args = params.toArray();


        int totalRecord = clazzDao.getTotalRecord(
                "select count(cid) " + hql, args);

        PageBean<Clazz> pageBean = new PageBean<>(pageNum, pageSize, totalRecord);

        List<Clazz> clazzList = clazzDao.selectAll(hql, args,
                pageBean.getStartIndex(),
                pageBean.getPageSize());

        pageBean.setBeanList(clazzList);

        return pageBean;
    }
}
