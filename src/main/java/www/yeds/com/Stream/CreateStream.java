package www.yeds.com.Stream;

import com.google.common.collect.Lists;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com.Stream
 * @ClassName: CreateStream
 * @Description: 有5中创建stream的方式
 * @author: yeds
 * @date: 2019/11/11 20:10
 * @version: V1.0
 */
public class CreateStream {

    /**
     * @method: appByArray
     * 功能描述: 使用数组创建stream
     */
    public static void appByArray() {
        String[] strs = {"a","b","c"};
        Stream<String> stream = Stream.of(strs);
        Stream<String> stream1 = Arrays.stream(strs);
        stream.forEach(System.out::println);
    }

    /**
    * @method: appByCollec
    * 功能描述:从集合中创建
    */
    public static void appByCollec() {
        HashMap map = new HashMap<String,Integer>() {
            {
                put("123", 1);
                put("1245", 123);
            }
        };
        System.out.println(map);
        List list = Arrays.asList("www.","yeds",".site");
        Stream stream = list.stream();
        stream.forEach(System.out::println);
    }

    /**
     * 使用Stream.generate()方法创建stream
     */
    public static void appByGenerate() {
        Stream<Integer> integerStream = Stream.generate(() -> 1);
        integerStream.limit(10).forEach(System.out::println);
    }

    /**
     * 使用Stream.iterate()方法创建stream
     */
    public static void appByIterate() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
        stream.limit(10).forEach(System.out::println);
    }

    public static void appByOther() {
        String str = "abcd";
        IntStream stream = str.chars();

//        stream.forEach(x -> System.out.println(x));
        //可以转换为静态方法的引用
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        appByArray();
        System.out.println("------");
        appByCollec();
        System.out.println("------");
        appByGenerate();
        System.out.println("------");
        appByIterate();
        System.out.println("------");
        appByOther();
    }
}
