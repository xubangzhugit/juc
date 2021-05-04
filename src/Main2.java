import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main2 {    public static void main(String[] args){
        //1,故障现象
        //java.util.ConcurrentModificationException
        //2,导致原因
        //     线程并发争抢资源不安全
        //3，解决方法
          /*1 vektor:线程安全
          * 2 List<String> list = Collections.synchronizedList(new ArrayList<String>())
          * 3 new  CopyOnWriteArrayList()  写时复制（建议使用）
          * */
        //4，优化建议
/*
byte[] by = new byte[20*1024*1024];
    System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(126877696/1024/1024);
*/
       List<String> list = new ArrayList<String>();
    Map<String ,String> map   = new HashMap<>();
    for (int i = 0;i < 14; i++) {
        map.put("1"+i,"a"+i);
    }
        //List<String> list = new  CopyOnWriteArrayList();
        /*for (int i=0;i<30;i++){
             new Thread(() -> {
                 list.add(UUID.randomUUID().toString().substring(0,8));
                 System.out.println(list);
             },"A").start();
        }*/
    }
}
