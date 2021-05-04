import com.sun.javafx.image.IntPixelGetter;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> future = new FutureTask<Integer>(new Call());
        new Thread(future,"callable").start();
        Integer integer = (Integer) future.get();
        System.out.println(integer);
    }
}
/**
 * Runnable 和callable 对比
 * 1：一个是run()，一个是call()
 * 2：Runnable不能抛异常，callable能抛异常
 * 3：Runnable没有返回值，callable有返回值
 *
 */
class Run implements  Runnable{
    @Override
    public void run() {
        System.out.println("run....");
    }
}
class Call implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("call....");
        return 1024;
    }
}
