


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
//    synchronized static public void synSay() {
//        System.out.println("static synSay----" + Thread.currentThread().getName());
//        while (true) { //保证进入该方法的线程 一直占用着该同步方法
//
//        }
//    }
//
//    synchronized public void synSay1() {
//        System.out.println("synSay1----" + Thread.currentThread().getName());
//    }
//
//    public void say() {
//        System.out.println("say----" + Thread.currentThread().getName());
//    }
//    public static void main1(String[] args){
//        Test test1 = new Test();
//        Test test2 = new Test();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test1.synSay();
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);  //休眠3秒钟 保证线程t1先执行
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                test1.say();
//                test2.say();
//                test1.synSay();
//                System.out.println("......");
//            }
//        });
//
//        t1.start();
//        t2.start();
//    }
    public static void main(String[] args) throws Exception{
       // Stream.generate(() -> UUID.randomUUID().toString().substring(0,8)).limit(9).skip(4).forEach(System.out::println);
       /* Stream<Object> nihao = Stream.of("nihao", 12, 2, 4);
        nihao.forEach(System.out::println);
        Stream.iterate(0,(i) -> {
            return 4;
        }).limit(5).forEach(System.out::println);
        Arrays.asList(1,3,4,5,6).stream().map((e) -> {
            return e*e;
        }).forEach(System.out::println);
        Integer reduce = Arrays.asList(1, 3, 4, 5, 6).stream().reduce(3, (a, b) -> {
            return a * b;
        });
        Arrays.asList(1, 3, 4, 5, 6).stream().sorted((a,c) -> {
            return Integer.compare(c,a);
        }).forEach(System.out::println);
        Arrays.asList(1, 3, 4, 5, 6).stream().reduce(1, Integer::compare);
        String reduce1 = Arrays.asList("1", "2", "f", "t").stream().collect(Collectors.joining("---","aa","000"));
        System.out.println(reduce1);
        System.out.println( Arrays.asList("1", "3", "4", "5", "6").stream().collect(Collectors.summingInt(Integer::parseInt)));
        System.out.println( Arrays.asList("1", "3", "4", "5", "6").stream().max(String::compareTo).get());
       Class<Unsafe> unsafe =  Unsafe.class;
        Field theUnsafe = unsafe.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Object o = theUnsafe.get(null);
        System.out.println(o);*/
        List<ThreadPoolDemo> list= new ArrayList<ThreadPoolDemo>();
        while(true)
        {
            list.add(new ThreadPoolDemo());
        }
//ok
    }

}
