package www.yeds.com;


import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com
 * @ClassName: Lambda1
 * @Description: TODO
 * @author: yeds
 * @date: 2019/9/16 20:36
 * @version: V1.0
 */
public class Lambda1 {

    public static void main(String[] args) throws Exception {

        //无参无返回值
        Runnable run0 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run0");
            }
        };
        Runnable run1 = () -> {System.out.println("run1");};
        Runnable run2 = () -> System.out.println("run2");
        run0.run();
        run1.run();
        run2.run();

        //无参有返回值
        Callable<String> call0 =new Callable() {
            @Override
            public Object call() throws Exception {
                return "call0";
            }
        };
        Callable<String> call1 = () -> {return "call2";};
        Callable<String> call2 = () -> "call2";
        System.out.println(call0.call());
        System.out.println(call1.call());
        System.out.println(call2.call());

        //有参无返回值
        Readable readable0 = new Readable() {
            @Override
            public void read(String book) {
                System.out.println(book);
            }
        };
        String book1 = "1：时间简史";
        Readable readable1 = (book) -> {System.out.println(book);};
        Readable readable2 = (String book) -> System.out.println(book);
        readable0.read("1:时间简史");
        readable1.read("2:百年孤独");
        readable2.read("3:薛定谔的猫");
        //有参有返回值
        UserMapper userMapper0 = (name) -> {return "userMapper0 add "+name+" success!";};
        UserMapper userMapper1 = name -> "userMapper1 add " + name + " success!";
        System.out.println(userMapper0.add("yds"));
        System.out.println(userMapper1.add("martin"));

        //有参有返回值、多语句的
        Function<Integer, Integer> sum = input -> {
            int output = 0;
            for (int i = 1; i <= input; i++) {
                output += i;
            }
            return output;
        };
        System.out.println(sum.apply(10));
    }
}
