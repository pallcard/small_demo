package main.java.cn.wishhust.design.mode.template;

public class Test {
    public static void main(String[] args) {
        BaseManage um = new UserManage();
        um.action("admin", "add");
        System.out.println("+++++++++++++++");
        um.action("normal", "add");
    }
}
