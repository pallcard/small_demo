package cn.wishhust.design.mode.strategy;

public abstract class BaseService {
    private ISave save;

    public void setIsave(ISave save) {
        this.save = save;
    }

    public void save(String data) {
        save.save(data);
    }
}
