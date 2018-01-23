package com.ssh.service.impl;

import com.ssh.dao.StudentDao;
import com.ssh.domain.Student;
import com.ssh.page.PageBean;
import com.ssh.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public List<Student> searchStudent(Student student) {
        String hql = "from Student where 1=1 ";
        Object[] args;

        List<Object> params = new ArrayList<>();
        if (!StringUtils.isBlank(student.getSname())) {
            hql += " and sname like ?";
            params.add("%" + student.getSname() + "%");
        }

        if (!StringUtils.isBlank(student.getSpassword())) {
            hql += " and spassword like ?";
            params.add("%" + student.getSpassword() + "%");
        }

        if (!StringUtils.isBlank(student.getClazzId())) {
            hql += " and clazzId = ?";
            int cid = Integer.parseInt(student.getClazzId());
            params.add(cid);
        }

        args = params.toArray();

        return studentDao.selectAll(hql, args);
    }

    @Override
    public PageBean<Student> searchStudent(Student student, int pageNum, int pageSize) {

        String hql = "from Student where 1=1 ";
        Object[] args;

        List<Object> params = new ArrayList<>();
        if (!StringUtils.isBlank(student.getSname())) {
            hql += " and sname like ?";
            params.add("%" + student.getSname() + "%");
        }

        if (!StringUtils.isBlank(student.getSpassword())) {
            hql += " and spassword like ?";
            params.add("%" + student.getSpassword() + "%");
        }

        if (!StringUtils.isBlank(student.getClazzId())) {
            hql += " and clazzId = ?";
            int cid = Integer.parseInt(student.getClazzId());
            params.add(cid);
        }

        args = params.toArray();

        int totalRecord = studentDao.getTotalRecord(
                "select count(sid) " + hql, args);

        PageBean<Student> pageBean = new PageBean<>(pageNum, pageSize, totalRecord);

        List<Student> studentList = studentDao.selectAll(hql, args,
                pageBean.getStartIndex(),
                pageBean.getPageSize());

        pageBean.setBeanList(studentList);

        return pageBean;
    }
}
