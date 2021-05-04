import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JUFDemo {


    public static void main(String[] args){
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.stream().filter(s -> {
            return s/2==1;
        }).filter(s -> {
            return s%2==0;
        }).forEach(System.out::println);

        List<Integer> list2 = Arrays.asList(1,23,44,5);
        list2.stream().map(s -> {
            return s*2;
        }).sorted((a,b) -> {
            return b.compareTo(a);//排序
        })
        .collect(Collectors.toList());//流转list
        /**
         * 函数型接口
         */
        Function<String ,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return null;
            }
        };
        function.apply("1");
        /**
         * 断定型接口
         */
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        predicate.test("a");
        /**
         * 消费型接口
         */
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };
        consumer.accept("a");
        /**
         * 供给型接口
         */
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };
        supplier.get();

    }
}
