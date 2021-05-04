import java.util.concurrent.*;

public class ThreadPoolDemo {


    public static void main(String[] args){


        // ExecutorService executorService = Executors.newFixedThreadPool(3);//创建固定数量的线程池
        //  ExecutorService executorService = Executors.newSingleThreadExecutor();//创建单个线程的线程池
         // ExecutorService executorService = Executors.newCachedThreadPool();//可扩容的线程池，创建N个线程的线程池
        //ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),//默认值integer最大
                Executors.defaultThreadFactory(),
                //四大拒绝策略
                new ThreadPoolExecutor.AbortPolicy()//中断
                //ThreadPoolExecutor.DiscardOldestPolicy//抛弃等待队列中时间最长的线程
                //ThreadPoolExecutor.CallerRunsPolicy 回退
               // ThreadPoolExecutor.DiscardPolicy//抛弃无法处理的任务，
        );
        try{
           for (int i = 0;i < 10; i++) {
               executorService.execute(() -> {
                   System.out.println(Thread.currentThread().getName()+"////////");
               });
              //Unit.SECONDS.sleep(2);
           }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            executorService.shutdown();
        }

    }
}
