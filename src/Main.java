import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class Main {
    /**
     * 1 在高内聚低耦合的前提下： 线程 操作 资源类
     *
     * @param args
     */
    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        Ticket ticket = new Ticket();

            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<40;i++) {
                        ticket.sale();
                    }
                }
            }, "thread1").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<40;i++) {
                        ticket.sale();
                    }
                }
            }, "thread2").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<40;i++) {
                        ticket.sale();
                    }
                }
            }, "thread3").start();*/
        new Thread(() -> {for(int i=0;i<40;i++) {
            try {
                ticket.sale();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        },"a").start();
        new Thread(() -> {for(int i=0;i<40;i++) {
            try {
                ticket.sale();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        },"b").start();
        new Thread(() -> {for(int i=0;i<40;i++) {
            try {
                ticket.sale();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        },"c").start();

    }
}

/**
 * 资源类
 */
class Ticket {
    private int number = 30;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void sale() throws Exception{
        condition.await();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第：" + (number--) + "\t还剩下" + number);

            }
        } finally {
            //lock.unlock();
            condition.signalAll();
        }

    }

}
@FunctionalInterface
interface  Foo{
    public void sayHello();
    default  int sum1(int a,int b ){
        return a+b;
    }
    default  int sum2(int a,int b ){
        return a+b;
    }
    static  int sum3(int a,int b ){
        return a+b;
    }
    static  int sum4(int a,int b ){
        return a+b;
    }
}