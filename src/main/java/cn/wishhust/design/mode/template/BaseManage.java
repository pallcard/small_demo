package cn.wishhust.design.mode.template;

public abstract class BaseManage {
    public void action(String name, String method) {
        System.out.println("公共部分");
        if("admin".equals(name)) {
            // 可变部分，让子类实现
            execute(method);
        } else {
            System.out.println("你没有权限");
        }
    }

    public abstract void execute(String method);

}
