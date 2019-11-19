package www.yeds.com.Stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com.Stream
 * @ClassName: TypeOfStream
 * @Description: 流的种类
 * @author: yeds
 * @date: 2019/11/19 20:55
 * @version: V1.0
 */
public class TypeOfStream {

    public static void main(String[] args) {
        //串行流：单线程
        /*Optional<Integer> maxByOne = Stream.iterate(1, x -> x + 1).limit(50).peek(
                x -> System.out.println(Thread.currentThread().getName())
        ).max(Integer::compareTo);
        System.out.println(maxByOne);*/
        System.out.println("****************************");
        //并行流：多线程;线程的个数由：ForkJoinPool决定
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");
        Optional<Integer> maxByMany = Stream.iterate(1, x -> x + 1).limit(50).peek(
                x -> System.out.println(Thread.currentThread().getName())
        ).parallel().max(Integer::compareTo);
        System.out.println(maxByMany);
    }
}
