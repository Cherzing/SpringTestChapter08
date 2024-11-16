package cn.cherzing.demo1;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 8:43
 * @description MyAspect
 */
public class MyAspect {
    /**
     * 切面中的两个通知
     */
    public void check_Permissions(){
        System.out.println("模拟检验权限(MyAspect)");
    }
    public void log(){
        System.out.println("模拟记录日志(MyAspect)");
    }
}
