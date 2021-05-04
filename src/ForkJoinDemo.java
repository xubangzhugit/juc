import javafx.concurrent.Task;

import java.nio.channels.MulticastChannel;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {

    /**
     * ForkJoinPool
     * ForkJoinTask
     * RecursiveTask : 递归task
     * @param args
     */
    public static void main(String[] args)throws Exception{
        ForkJoinPool forkJoinPool =new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(new MyTask(0, 100));
        Integer integer = submit.get();
        System.out.println(integer);
    }
}
class MyTask extends RecursiveTask<Integer>{
     private static final Integer VALUE = 10;
     private  int begin;
     private int end;
     private int result;
     public MyTask(int begin,int end){
         this.begin = begin;
         this.end = end;
     }
    @Override
    protected Integer compute() {
        if((begin- end)<= VALUE){
             for (int i = begin;i <= end; i++) {
                result+=i;
             }
        }else{
            int milled = (begin+end)/2;
            MyTask myTask1 = new MyTask(begin,milled);
            MyTask myTask2 = new MyTask(begin,milled);
            myTask1.fork();
            myTask2.fork();
            result= myTask1.join()+ myTask2.join();
        }
        return result;
    }
}
