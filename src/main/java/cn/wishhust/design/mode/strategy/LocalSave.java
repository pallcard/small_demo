package main.java.cn.wishhust.design.mode.strategy;

/**
 * 存放到文件中
 */
public class LocalSave implements ISave{
    @Override
    public void save(String data) {
        System.out.println("文件：" + data + "已经存放到本地了");
    }
}
