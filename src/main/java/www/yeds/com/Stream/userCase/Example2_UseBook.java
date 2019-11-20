package www.yeds.com.Stream.userCase;

import com.google.common.collect.Lists;
import org.junit.Test;
import www.yeds.com.Stream.entity.Book;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
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
        books.add(new Book(14, "vue", 35D, LocalDate.parse("2016-07-30")));
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


        //只要价格顺序
        List<Double> priceList = books.stream().map(Book::getPrice).distinct().sorted().collect(Collectors.toList());
        System.out.println(priceList);
    }
}
