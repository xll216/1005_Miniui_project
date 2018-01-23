package com.ssh.service;

import com.ssh.domain.Clazz;
import com.ssh.page.PageBean;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface ClazzService {
    List<Clazz> searchClazz(Clazz clazz);

    PageBean<Clazz> searchClazz(Clazz clazz,
                                int pageNum,
                                int pageSize);
}
