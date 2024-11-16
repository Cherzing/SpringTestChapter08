package cn.cherzing.demo4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 22:43
 * @description AnnoAdvice
 */
@Aspect
public class AnnoAdvice {
    @Pointcut("execution(* cn.cherzing.demo3.UserDaoImpl.*(..))")
    public void pointcut(){
    }
    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("(前置通知)");
        System.out.println("目标类是"+joinPoint.getTarget()+",被植入增强处理方法的目标方法为" +
                joinPoint.getSignature().getName());
    }
    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("(返回通知)");
        System.out.println("目标类是"+joinPoint.getTarget()+",被植入增强处理方法的目标方法为" +
                joinPoint.getSignature().getName());
    }
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("(环绕通知之前的部分)");
        Object object = point.proceed();
        System.out.println("(环绕通知之后的部分)");
        return object;
    }
   @AfterThrowing("pointcut()")
    public void afterException(){
        System.out.println("异常通知");
    }
    @After("pointcut()")
    public void after(){
        System.out.println("这是后置通知");
    }
}
