package cn.cherzing.demo1;

/**
 * @author Cherzing
 * @date 2024/11/14 0014 8:42
 * @description UserDaoImpl
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户(UserDaoImpl)");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户(UserDaoImpl)");
    }
}
