import java.util.concurrent.CountDownLatch;

public class CountDownLanch {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);//指定跑完6个线程之后放行
        for(int i=1;i<=6;i++){
             new Thread(() -> {

                 System.out.println(Thread.currentThread().getName()+"--------");countDownLatch.countDown();
             },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"///////////");
    }
}
