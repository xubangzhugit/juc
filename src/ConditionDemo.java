import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    public static void main(String[] args) {
        /*
         * 多线程之间实现顺序调用，A->B->C
         * A打印5次，A打印10次，A打印15次
         * */
        Share sha = new Share();
         new Thread(() -> {
             for (int i=0;i<5;i++) {
                 sha.aa();
             }
         },"AA").start();
        new Thread(() -> {
            for (int i=0;i<10;i++) {
                sha.bb();
            }
        },"BB").start();
        new Thread(() -> {
            for (int i=0;i<15;i++) {
                sha.cc();
            }
        },"CC").start();
    }
}

class Share {
    private int number = 1;//A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void aa() {
        lock.lock();
        try {
            while (number !=1) {
                condition1.await();
            }
            for (int i=0;i<5;i++) {
                System.out.println(Thread.currentThread().getName()+"---------"+(i+1));
            }
            number = 2;  //更改标志位
            condition2.signal();//唤醒BB
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void bb() {
        lock.lock();
        try {
            while (number !=2) {
                condition2.await();
            }
            for (int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName()+"---------"+(i+1));
            }
            number = 3;  //更改标志位
            condition3.signal();//唤醒BB
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void cc() {
        lock.lock();
        try {
            while (number !=3) {
                condition3.await();
            }
            for (int i=0;i<15;i++) {
                System.out.println(Thread.currentThread().getName()+"---------"+(i+1));
            }
            number = 1;  //更改标志位
            condition1.signal();//唤醒BB
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

