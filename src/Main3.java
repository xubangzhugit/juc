import org.openjdk.jol.info.ClassLayout;

public class Main3 {
    public static void main(String[] args){
        A a = new A();                                                 //锁膨胀过程
        System.out.println(ClassLayout.parseInstance(a).toPrintable());//无锁可偏向
        System.out.println(a.hashCode());
        System.out.println(ClassLayout.parseInstance(a).toPrintable());//无锁不可偏向
        synchronized (a){
            System.out.println(ClassLayout.parseInstance(a).toPrintable());//轻量级锁（线程交替执行）
        }                                                                  //重量级锁（存在线程竞争）
       /* new Thread(() -> {
         for (int i=0;i<10;i++) {
             try {
                 a.inc();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     },"a").start();
        new Thread(() -> {
            for (int i=0;i<10;i++) {
                try {
                    a.dec();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"b").start();
        new Thread(() -> {
            for (int i=0;i<10;i++) {
                try {
                    a.inc();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"c").start();
        new Thread(() -> {
            for (int i=0;i<10;i++) {
                try {
                    a.dec();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"d").start();*/
    }
}
class A{
    private int number=0;

    public  synchronized  void inc()throws Exception{
        while(number!=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"--------"+number);
        this.notifyAll();

    }
    public synchronized void dec()throws Exception{
       while(number==0){
           this.wait();
       }
           number--;
           System.out.println(Thread.currentThread().getName()+"--------"+number);
           this.notifyAll();

    }
}
