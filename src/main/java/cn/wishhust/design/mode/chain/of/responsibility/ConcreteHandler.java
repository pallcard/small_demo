package cn.wishhust.design.mode.chain.of.responsibility;

public class ConcreteHandler extends Handler {

    String name = "";

    public ConcreteHandler(String name) {
        this.name = name;
    }

    /**
     * 处理方法，调用此方法处理请求
     */

    @Override
    public void handleRequest() {
        /**
         * 判断是否有后继的责任对象
         * 如果有，就转发请求给后继的责任对象
         * 如果没有，则处理请求
         */
        if(getSuccessor() != null)
        {
            System.out.println(name + "放过请求");
            getSuccessor().handleRequest();
        }else
        {
            System.out.println(name + "处理请求");
        }
    }
}
