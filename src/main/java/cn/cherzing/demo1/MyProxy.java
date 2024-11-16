package cn.cherzing.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 8:52
 * @description MyProxy
 */
public class MyProxy implements InvocationHandler {
    private UserDao userDao;

    /**
     * 创建一个动态代理对象
     * @param userDao
     * @return
     */
    public Object createProxy(UserDao userDao){
        this.userDao = userDao;
        //类加载器
        ClassLoader classLoader = MyProxy.class.getClassLoader();
        //被代理对象实现的所有接口
        Class[] classes = userDao.getClass().getInterfaces();
        //使用代理对象进行增强，返回的是代理对象
        return Proxy.newProxyInstance(classLoader,classes,this);
    }

    /**
     * 所有的动态代理类的方法调用，都会交由invoke()方法处理
     *
     * @param proxy the proxy instance that the method was invoked on
     *
     * @param method the {@code Method} instance corresponding to
     * the interface method invoked on the proxy instance.  The declaring
     * class of the {@code Method} object will be the interface that
     * the method was declared in, which may be a superinterface of the
     * proxy interface that the proxy class inherits the method through.
     *
     * @param args an array of objects containing the values of the
     * arguments passed in the method invocation on the proxy instance,
     * or {@code null} if interface method takes no arguments.
     * Arguments of primitive types are wrapped in instances of the
     * appropriate primitive wrapper class, such as
     * {@code java.lang.Integer} or {@code java.lang.Boolean}.
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.check_Permissions();
        Object invoke = method.invoke(userDao, args);
        myAspect.log();
        return invoke;
    }
}
