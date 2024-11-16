package cn.cherzing;

import cn.cherzing.demo2.CglibProxy;
import cn.cherzing.demo2.UserDao;
import org.junit.Test;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 9:28
 * @description CglibTest
 */
public class CglibTest {
    @Test
    public void test(){
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = new UserDao();
        UserDao userDao1 =(UserDao)cglibProxy.createProxy(userDao);
        userDao1.addUser();
        System.out.println();
        userDao1.deleteUser();
    }
}
