import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args){
        Semaphore semaphore  = new Semaphore(3);
        for(int i=1;i<=6;i++){
            new Thread(() -> {
                try {
                    semaphore.acquire();//semaphore减一
                    System.out.println(Thread.currentThread().getName()+"--------");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore.release();//semaphore加一
                }
            },String.valueOf(i)).start();
        }
    }
}
