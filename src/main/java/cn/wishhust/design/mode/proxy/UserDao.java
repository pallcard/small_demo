package cn.wishhust.design.mode.proxy;

public class UserDao implements IUserDao{

    @Override
    public void savaUser() {
        System.out.println("保存用户成功");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户成功");
    }
}
