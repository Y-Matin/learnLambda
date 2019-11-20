package www.yeds.com.Stream.userCase;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com.Stream
 * @ClassName: Example1
 * @Description: 例子1：解析url
 *  将index.html?itemId=1&userId=1890&token=1klsdzfi131223j2&key=index
 *  转换为map，把itemId转为key，值转换为对应的value
 * @author: yeds
 * @date: 2019/11/19 21:19
 * @version: V1.0
 */
public class Example1 {

    public static void main(String[] args) {
        String url = "itemId=1&userId=1890&token=1klsdzfi131223j2&key=index";
        Map<String, String> map = Stream.of(url.split("&")).map(str -> str.split("="))
                .collect(Collectors.toMap(s -> s[0], s -> s[1]));
        //由以上表决式可知，stream 流的执行方式为：
        //  先让一个item经过所有的操作（中间操作，终止操作）；
        //  并非是先让所有的item经过中间操作后，在一起经过终止操作。
        System.out.println(map);
        //{itemId=1, userId=1890, key=index, token=1klsdzfi131223j2}
    }
}
