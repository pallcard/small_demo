package cn.wishhust.design.mode.proxy;


public class UserProxy implements IUserDao {

    private IUserDao target;

    public UserProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void savaUser() {
        System.out.println("代理执行。。。。");

        target.savaUser();

        System.out.println("代理执行。。。");
    }

    @Override
    public void deleteUser() {
        System.out.println("代理执行。。。。");

        target.deleteUser();

        System.out.println("代理执行。。。");
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        UserProxy userProxy = new UserProxy(userDao);

        userProxy.savaUser();
    }
}
