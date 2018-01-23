package com.ssh.service;

import com.ssh.domain.Student;
import com.ssh.page.PageBean;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface StudentService {
    List<Student> searchStudent(Student student);


    PageBean<Student> searchStudent(Student student,
                                    int pageNum,
                                    int pageSize);
}
