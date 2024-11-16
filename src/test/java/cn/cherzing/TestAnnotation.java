package cn.cherzing;

import cn.cherzing.demo3.UserDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 22:54
 * @description TestAnnotation
 */
public class TestAnnotation {
    @Test
    public void testAnno(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.select();
        userDao.delete();
        userDao.insert();
        userDao.update();
    }
}
