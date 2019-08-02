package main.java.cn.wishhust.design.mode.strategy;

public class UserService extends BaseService {

    public static void main(String[] args) {
        BaseService user = new UserService();
        user.setIsave(new NetSave());
        user.save("文件1");
        user.setIsave(new LocalSave());
        user.save("文件2");
    }

}
