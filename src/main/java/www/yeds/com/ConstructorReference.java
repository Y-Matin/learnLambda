package www.yeds.com;

import java.util.function.Supplier;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com
 * @ClassName: ConstructorReference
 * @Description: 构造方法引用
 * 如果函数式接口的实现恰好可以通过调用一个类的构造方法来实现，那么就可以使用构造方法引用
 * 构造方法引用	类名::new	(args) -> new 类名(args)
 * @author: yeds
 * @date: 2019/11/10 11:35
 * @version: V1.0
 */

public class ConstructorReference {



    public static void main(String[] args) {
        //1.1 常规lambda表达式
        Supplier<ConstructorReference> cons1 = () -> new ConstructorReference();
        //1.2 使用构造方法引用
        Supplier<ConstructorReference> cons2 = ConstructorReference::new;
    }
}
