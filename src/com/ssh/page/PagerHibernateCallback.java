package com.ssh.page;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class PagerHibernateCallback<T>
        implements HibernateCallback<List<T>> {

    private String hql;
    private Object[] params;
    private int startIndex;
    private int pageSize;

    public PagerHibernateCallback() {
    }

    public PagerHibernateCallback(String hql,
                                  Object[] params,
                                  int startIndex,
                                  int pageSize) {
        this.hql = hql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {
        Query query = session.createQuery(hql);

        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params[i]);
        }

        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);

        return query.list();
    }
}
