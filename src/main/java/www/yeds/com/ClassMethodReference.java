package www.yeds.com;

import java.util.function.BiFunction;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com
 * @ClassName: ClassMethodReference
 * @Description: 练习使用 对象方法引用
 * @author: yeds
 * @date: 2019/10/4 20:47
 * @version: V1.0
 */
public class ClassMethodReference {

    public int length(String str) {
        return str.length();
    }

    /**
     * 抽象方法的第一个参数类型刚好是实例方法的类型，抽象方法剩余的参数恰好可以当做实例方法的参数
     * 对象方法引用	类名::instMethod	(int,args) ->类名.instMethod(args)
     * @param args
     */
    public static void main(String[] args) {

        //使用方法：入参为方法所属类的类型，剩余参数为该方法的入参
        //传统方式
        BiFunction<ClassMethodReference, String, Integer> biFunction = (bi, str) -> bi.length(str);
        // 对象方法引用
        BiFunction<ClassMethodReference, String, Integer> biFunction1 = ClassMethodReference::length;
        BiFunction<Temp, String, String> biFunction2 = Temp::toUpper;
        //使用自己的接口 引用 自己自定义的类的方法
        Inter inter = Temp::toUpper;
        System.out.println(biFunction.apply(new ClassMethodReference(), "123456"));
        System.out.println(biFunction1.apply(new ClassMethodReference(), "admin"));
        System.out.println(biFunction2.apply(new Temp(), "dsdfasdfasdfas"));
        System.out.println(inter.exec(new Temp(), "admin-admin"));
    }
}


interface Inter {
    String exec(Temp temp, String str);
}

class Temp {
    public String toUpper(String str) {
        return str.toUpperCase();
    }
}
