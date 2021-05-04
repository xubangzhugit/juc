import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    /**
     * CyclicBarrier 适合做线程加法
     * @param args
     */
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("结束。。。。。。。。");
        });
        for(int i=1;i<=7;i++){
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName()+"--------");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }
    }
}
