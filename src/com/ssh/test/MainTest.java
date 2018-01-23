package com.ssh.test;

import com.ssh.dao.StudentDao;
import com.ssh.domain.Clazz;
import com.ssh.domain.Student;
import com.ssh.service.ClazzService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class MainTest {

    private ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext(
                "classpath*:spring-servlet.xml");
    }

    @Test
    public void testDao() {
        StudentDao studentDao = context.getBean(StudentDao.class);
        Student student = studentDao.selectByID(1);
        System.out.println(student);

        String sql = "from Student where sname like ?";
        Object[] args = {"%王%"};
        List<Student> students = studentDao.selectAll(sql, args);
        System.out.println(students);
    }

    @Test
    public void testService() {
        ClazzService clazzService = context.getBean(ClazzService.class);

        Clazz clazz = new Clazz();
        List<Clazz> clazzes = clazzService.searchClazz(clazz);
        System.out.println(clazzes);


    }
}
