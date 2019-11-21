package www.yeds.com.Stream.userCase;

import com.google.common.collect.Lists;
import org.junit.Test;
import www.yeds.com.Stream.entity.Book;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com.Stream.userCase
 * @ClassName: Example2_UseBook
 * @Description: 从对象中提取某一类型 转为另一个list。
 * @author: yeds
 * @date: 2019/11/20 21:03
 * @version: V1.0
 */
public class Example2_UseBook {

    static List<Book> init() {
        List<Book> books = Lists.newArrayList();
        books.add(new Book(1, "tomcat", 50D, LocalDate.parse("2019-11-20")));
        books.add(new Book(2, "jetty", 60D, LocalDate.parse("2014-01-20")));
        books.add(new Book(3, "nginx", 30D, LocalDate.parse("2012-03-11")));
        books.add(new Book(4, "php", 55D, LocalDate.parse("2013-05-13")));
        books.add(new Book(5, "ruby", 55D, LocalDate.parse("2013-07-19")));
        books.add(new Book(6, "mysql", 49D, LocalDate.parse("2011-09-09")));
        books.add(new Book(7, "ssh", 80D, LocalDate.parse("2017-12-19")));
        books.add(new Book(8, "设计模式", 100D, LocalDate.parse("2012-02-01")));
        books.add(new Book(9, "敏捷开发", 85D, LocalDate.parse("2013-04-24")));
        books.add(new Book(10, "jvm", 64D, LocalDate.parse("2015-09-23")));
        books.add(new Book(11, "spring", 46D, LocalDate.parse("2016-11-27")));
        books.add(new Book(12, "spring boot", 38D, LocalDate.parse("2017-07-11")));
        books.add(new Book(13, "spring cloud", 79D, LocalDate.parse("2018-03-18")));
        books.add(new Book(14, "vue", 64D, LocalDate.parse("2016-07-30")));
        books.add(new Book(15, "react", 59D, LocalDate.parse("2015-05-27")));
        return books;
    }

    @Test
    public void test1() {
        List<Book> books = init();
        //1.将id提取出来转换为list
        List<Integer> integers = books.stream().map(Book::getId).collect(Collectors.toList());
        System.out.println(integers);
    }

    @Test
    public void test2() {
        List<Book> books = init();
        //2.把id 提取出来、 转换为用逗号分隔的字符串
        String ids_str1 = books.stream().map(book -> book.getId() + "").collect(Collectors.joining(","));
        System.out.println(ids_str1);
        //添加前后缀
        String ids_str2 = books.stream().map(book -> book.getId() + "").collect(Collectors.joining(",", "(", ")"));
        System.out.println(ids_str2);
    }

    @Test
    public void test3() {
        List<Book> books = init();
        //3.按照 价格 排序
        //把book对象按照价格升序排序
        books.stream().sorted(Comparator.comparingDouble(Book::getPrice)).forEach(System.out::println);
        //按照价格降排序
        books.stream().sorted(Comparator.comparingDouble(Book::getPrice).reversed()).forEach(System.out::println);

        //先按照 价格升序，再按照 日期降序
        // 比较：compartor<T>,若无明确结果，默认表达式是小于0的，若"（a,b）->a-b"则代表a-b<0 => a<b 即为升序；若已返回确定值，若返回值小于0，则代表降序。
        //Comparator.comparingDouble(Book::getPrice) ： 提供了便利的比较方法。只需传入对象的字段 即可。
        books.stream().sorted(Comparator.comparingDouble(Book::getPrice).thenComparing(Book::getPublishDate).reversed()).forEach(System.out::println);

        //只要价格顺序列表
        List<Double> priceList = books.stream().map(Book::getPrice).distinct().sorted().collect(Collectors.toList());
        System.out.println(priceList);
    }

    @Test
    public void test4() {
        //将对象转换为map<int,object>
        List<Book> books = init();
        Map<Integer, Book> bookMap = books.stream().collect(Collectors.toMap(Book::getId, book -> book));
        System.out.println(bookMap);
    }

    @Test
    public void test5() {
        //统计这些书的价格的平均值
        // 两种实现方法：
        List<Book> books = init();
        //转为mapToXXX，调用average方法
        OptionalDouble optionalDouble = books.stream().mapToDouble(Book::getPrice).average();
        System.out.println(optionalDouble.getAsDouble());
        //调用collectors中的averagingDouble方法
        Double collect = books.stream().collect(Collectors.averagingDouble(Book::getPrice));
        System.out.println(collect);
        //类似的：比如最大值，最小值以上两种方式都能实现。
        OptionalDouble max = books.stream().mapToDouble(Book::getPrice).max();
        Optional<Book> optionalMax1 = books.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Book::getPrice)));
        Optional<Book> optionalMax2 = books.stream().max(Comparator.comparingDouble(Book::getPrice));

        System.out.println(max);
        System.out.println(optionalMax1);
        System.out.println(optionalMax2);


    }
}
