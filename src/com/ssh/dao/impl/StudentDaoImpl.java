package com.ssh.dao.impl;

import com.ssh.dao.StudentDao;
import com.ssh.domain.Student;
import org.springframework.stereotype.Repository;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Repository("studentDao")
public class StudentDaoImpl
        extends BaseDaoImpl<Student>
        implements StudentDao {


}
