package com.ssh.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface BaseDao<T> {
    List<T> selectAll(String sql, Object[] args);

    int getTotalRecord(String sql, Object[] args);

    List<T> selectAll(String sql, Object[] args, int startIndex, int pageSize);

    T selectByID(Serializable id);

}
