package main.java.cn.wishhust.apply;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 *  使用Map 实现简单的一个缓存
 *
 */

public class LocalCache {
    private static Map<String, LocalCacheItem> cache = new ConcurrentHashMap<>();

    public static <T> T getData(String key, Load<T> load, int expireTime) {
        T data = getData(key);
        if (null == data && null != load) {
            data = load.load();
            if (null != data) {
                setData(key, data, expireTime);
            }
        }
        return data;
    }

    public static <T> T getData(String key) {
        LocalCacheItem<T> data = cache.get(key);
        if (null != data && (data.getExpireTime() <= 0 || data.getSaveTime() >= new Date().getTime())) {
            return data.getData();
        }
        return null;
    }

    public static <T> void setData(String key, T data, int expireTime) {
        cache.put(key, new LocalCacheItem(data,expireTime));
    }


    public interface Load<T> {
        T load();
    }

    // 缓存数据项
    private static class LocalCacheItem<T> {
        T data;
        long saveTime;
        long expireTime;

        LocalCacheItem(T data, long expireTime) {
           this.data =  data;
           this.expireTime = expireTime*1000;
           this.saveTime = new Date().getTime() + this.expireTime;
        }

        public T getData() {
            return data;
        }

        public long getSaveTime() {
            return saveTime;
        }

        public long getExpireTime() {
            return expireTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String key = "test";
//        LocalCache.setData(key, "value", 1);
        LocalCache.getData(key, ()->"testValue",2);

        System.out.println(LocalCache.getData(key).toString());

        Thread.sleep(3*1000);
        System.out.println(LocalCache.getData(key)!=null ? LocalCache.getData(key).toString(): "");
    }
}
