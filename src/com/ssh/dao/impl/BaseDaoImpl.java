package com.ssh.dao.impl;

import com.ssh.dao.BaseDao;
import com.ssh.page.PagerHibernateCallback;
import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Resource
    private HibernateTemplate hibernateTemplate;
    private Class<T> beanClass;

    public BaseDaoImpl() {
        ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
        beanClass = (Class<T>) paramType.getActualTypeArguments()[0];
    }

    @Override
    public List<T> selectAll(String sql, Object[] args) {
        if (StringUtils.isBlank(sql)) {
            return hibernateTemplate.loadAll(beanClass);
        }
        return (List<T>) hibernateTemplate.find(sql, args);
    }

    @Override
    public int getTotalRecord(String sql, Object[] args) {
        //返回符合条件的条数集合
        List<Long> find = (List<Long>) hibernateTemplate.find(sql, args);

        if (find != null && find.size() > 0) {
            //得到总条数并返回
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<T> selectAll(String sql, Object[] args, int startIndex, int pageSize) {
        return hibernateTemplate.execute(
                new PagerHibernateCallback<T>(
                        sql, args, startIndex, pageSize));
    }

    @Override
    public T selectByID(Serializable id) {
        return hibernateTemplate.get(beanClass, id);
    }
}
