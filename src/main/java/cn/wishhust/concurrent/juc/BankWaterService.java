package cn.wishhust.concurrent.juc;

import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService implements Runnable{

    // 4个屏障处理完成，执行当前类当run方法
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);


    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();


    @Override
    public void run() {
        int result = 0;
        for(Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }

        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    private void count(){
        for (int i = 0; i < 4; i++) {
            executor.execute(()->{
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
