package www.yeds.com;

import java.util.function.Function;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com
 * @ClassName: StaticMethodReference
 * @Description: TODO
 * @author: yeds
 * @date: 2019/10/2 10:41
 * @version: V1.0
 */
public class StaticMethodReference {
    /**
     * 静态方法引用
     * 如果函数式接口的实现是通过调用一个静态方法来完成的，那么就可以使用使用静态方法引用
     * 静态方法引用	类名::staticMethod ==  (args) -> 类名.staticMethod(args)
     *
     * @param str
     * @return
     */

    public static String toUpper(String str) {
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        //静态方法引用
        //1.输入一个字符串，输出该字符串的大写
        Function<String, String> toUper = str -> str.toUpperCase();
        // 2.使用常规Lambda表达式
        Function<String, String> toUper1 = (str) -> StaticMethodReference.toUpper(str);
        // 3.使用静态方法引用
        Function<String, String> toUper2 = StaticMethodReference::toUpper;
        //调用
        System.out.println(toUper.apply("skdlfks"));
        System.out.println(toUper1.apply("admin"));
        System.out.println(toUper2.apply("martin"));

    }
}
