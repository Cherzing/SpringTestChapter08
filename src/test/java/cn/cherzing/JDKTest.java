package cn.cherzing;

import cn.cherzing.demo1.MyProxy;
import cn.cherzing.demo1.UserDao;
import cn.cherzing.demo1.UserDaoImpl;
import org.junit.Test;

import java.net.Proxy;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 9:08
 * @description JDKTest
 */
public class JDKTest {
    @Test
    public void testJDK(){
        MyProxy myProxy = new MyProxy();
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao proxy = (UserDao)myProxy.createProxy(userDao);
        proxy.addUser();
        System.out.println();
        proxy.deleteUser();
    }
}