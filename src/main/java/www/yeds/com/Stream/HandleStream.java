package www.yeds.com.Stream;

import java.util.*;

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
        OptionalInt max = integerList.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).max();
        System.out.println("max:" + max);

        Optional<Integer> max1 = integerList.stream().max(Comparator.comparingInt(a -> a));
        System.out.println("max1:"+max1);

    }
}
