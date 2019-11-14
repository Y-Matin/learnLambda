package www.yeds.com.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com.Stream
 * @ClassName: HandleStream
 * @Description: 常见流的操作
 * @author: yeds
 * @date: 2019/11/12 21:31
 * @version: V1.0
 */
public class HandleStream {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1", "123", "1234", "12345","123456");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> mixedList = Arrays.asList(1, 12, 345, 2, 8, 0, 3, 6, 56);
        // 过滤操作(过滤掉字符长度小于2的)
        stringList.stream().filter(x -> x.length() > 2).forEach(System.out::println);
        System.out.println("-------");
        // 转换(将字符串转换为数字)、过滤操作(过滤掉奇数)
        stringList.stream().mapToInt(Integer::parseInt).filter(x->x%2==0).forEach(System.out::println);
        System.out.println("-------");
        // 过滤操作(过滤掉奇数)
        integerList.stream().filter(x->x%2==0).forEach(System.out::println);
        System.out.println("-------");
        //过滤、求和
        int sum = integerList.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println("sum:" + sum);
        System.out.println("-------");
        //过滤（奇数）、取最大值
        int asInt = integerList.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).max().getAsInt();
        System.out.println("max:" + asInt);
        // 取最大值，使用Comparator
        Integer max = integerList.stream().max(Comparator.comparingInt(o -> o)).get();
        System.out.println("max1:"+max);
        System.out.println("-------");
        // 查找、findAny/findFirst
        Optional<Integer> any = integerList.stream().findAny();
        System.out.println(any.get());
        System.out.println("-------");
        //排序 sored ，正反序
        mixedList.stream().sorted().forEach(System.out::println);
        System.out.println("-------");
        Integer firstMix = mixedList.stream().sorted().findFirst().get();
        System.out.println("sored-up: first： "+firstMix);
        System.out.println("-------");
        mixedList.stream().sorted((o1, o2) -> o2-o1).forEach(System.out::println);
        System.out.println("-------");
        Integer firstMax = mixedList.stream().sorted((o1, o2) -> o2-o1).findFirst().get();
        System.out.println("sored-down: first："+firstMax);
        System.out.println("-------");
        //截取，limite、skip
        Stream.iterate(1, x -> x + 1).limit(50).forEach(System.out::println);
        System.out.println("-------");
        Stream.iterate(1, x -> x + 1).limit(50).filter(x->x%2==0).forEach(System.out::println);
        System.out.println("-------");
        Stream.iterate(1, x -> x + 1).limit(50).filter(x -> x % 2 == 0).skip(10).forEach(System.out::println);
        System.out.println("-------");
        // 收集器 collect()
        List<Integer> collect = Stream.iterate(1, x -> x + 1).limit(10).collect(Collectors.toList());
        System.out.println(collect);
        // collect() ,toSet() 去重
        Set<Integer> set = Arrays.asList(1, 2, 3, 3, 5, 1).stream().collect(Collectors.toSet());
        System.out.println(set);
        // 去重 distinct()
        List<Integer> collect1 = Arrays.asList(1, 2, 3, 3, 5, 1).stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);


    }
}
