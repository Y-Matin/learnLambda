package www.yeds.com;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com
 * @ClassName: InstenceMethodReference
 * @Description: 实例方法引用
 *如果函数式接口的实现恰好可以通过调用一个实例的实例方法来实现，那么就可以使用实例方法引用
 * 实例方法引用	inst::instMethod	(args) -> inst.instMethod(args)
 * @author: yeds
 * @date: 2019/10/4 16:21
 * @version: V1.0
 */
public class InstenceMethodReference {

    public String toUpper(String str) {
        return str.toUpperCase();
    }

    public String sout() {
        System.out.println();
        return "12312";
    }

    public void out(String s) {
        System.out.println(s);
    }

    public static String upper(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        //实例方法引用
        //1.输入一个字符串，输出该字符串的大写
        Function<String, String> toUper = str -> str.toUpperCase();
        // 2.使用常规Lambda表达式
        Function<String, String> toUper1 = (str) -> new InstenceMethodReference().toUpper(str);
        // 3.1使用实例方法引用
        Function<String, String> toUper2 = new InstenceMethodReference()::toUpper;
        //3.2 对象方法引用
        BiConsumer<InstenceMethodReference, String> out1 = InstenceMethodReference::out;
        //3.2 使用对象方法引用   与实例方法使用区别<入参需要与方法所属的对象类型一致，后续的参数为该方法的入参>
        Function<InstenceMethodReference, String> toUper3 = InstenceMethodReference::sout;
        //3.3 静态方法引用
        Function<String, String> upper1 = InstenceMethodReference::upper;

        //调用
        System.out.println(toUper.apply("skdlfks"));
        System.out.println(toUper1.apply("admin"));
        System.out.println(toUper2.apply("martin"));

    }
}
