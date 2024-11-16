package cn.cherzing.demo3;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 9:46
 * @description UserDaoImpl
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void insert() {
        System.out.println("添加用户信息");
    }

    @Override
    public void delete() {
        System.out.println("删除用户信息");
    }

    @Override
    public void update() {
        System.out.println("更新用户信息");
    }

    @Override
    public void select() {
        System.out.println("删除用户信息");
    }
}
