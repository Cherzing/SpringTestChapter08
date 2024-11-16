package cn.cherzing.demo2;

import cn.cherzing.demo1.MyAspect;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 9:18
 * @description CglibProxy
 */
public class CglibProxy implements MethodInterceptor {
    /**
     * 代理方法
     * @param target
     * @return
     */
    public Object createProxy(Object target){
        // 创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        // 确定需要增强的类。设置其为父类
        enhancer.setSuperclass(target.getClass());
        // 增加回调函数
        enhancer.setCallback(this);
        return enhancer.create();
    }
    /**
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //创建切面类对象
        MyAspect myAspect = new MyAspect();
        // 增强
        myAspect.check_Permissions();
        //
        Object object = methodProxy.invokeSuper(o, objects);
        myAspect.log();

        return object;
    }
}
