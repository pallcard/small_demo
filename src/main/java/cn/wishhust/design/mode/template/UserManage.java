package main.java.cn.wishhust.design.mode.template;

public class UserManage extends BaseManage {
    @Override
    public void execute(String method) {
        if ("add".equals(method)) {
            System.out.println("执行add方法");
        } else {
            System.out.println("执行默认方法");
        }
    }
}
