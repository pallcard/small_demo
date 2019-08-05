package cn.wishhust.design.mode.strategy;

public class NetSave implements ISave {
    @Override
    public void save(String data) {
        System.out.println("文件：" + data + "已经存放到网络了");
    }
}
