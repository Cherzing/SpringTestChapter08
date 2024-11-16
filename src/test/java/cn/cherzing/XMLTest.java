package cn.cherzing;

import cn.cherzing.demo3.UserDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 22:34
 * @description XMLTest
 */
public class XMLTest {
    @Test
    public void testXML(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.select();
        userDao.delete();
        userDao.insert();
        userDao.update();

    }
}
