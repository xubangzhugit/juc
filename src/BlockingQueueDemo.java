import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args)throws Exception{

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.add("1");//添加元素。返回boolean
        blockingQueue.remove();//从队首移除元素，FIFO
        blockingQueue.element();//检查队首是否有元素。判断是否为空

        blockingQueue.offer("a");//添加元素，队列满时不会报错，返回false;
        blockingQueue.poll();//移除元素，移除完了返回nul;
        blockingQueue.peek();//检查队首是否有元素。

        blockingQueue.put("a");//添加，队列中元素满时，队列会阻塞，直到有元素被消费，队列有空位，
        blockingQueue.take();//移除，队列中元素空时，队列会阻塞，直到有元素被生成，

        blockingQueue.offer("a",3, TimeUnit.SECONDS);
    }
}
