package www.yeds.com.Stream.userCase;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: learnLambda
 * @Package: www.yeds.com.Stream
 * @ClassName: Case1
 * @Description: TODO
 * @author: yeds
 * @date: 2019/11/18 20:29
 * @version: V1.0
 */
public class Case1 {


    public static void main(String[] args) {
        /**
         * case1:
         * 将字符串切割为字符数组，将str转为int，再求和
         * @param args
         */
        String str = "11,22,33,44,55";
        int sum = Stream.of(str.split(",")).mapToInt(Integer::parseInt).sum();
        System.out.println(str);
        System.out.println(sum);
        int sum1 = Arrays.stream(str.split(",")).mapToInt(Integer::valueOf).sum();
        System.out.println(sum1);

        /**
         * case2:
         * 将字符串转换为对象
         */
        String userNames = "tomcat,nginx,apache,jetty";
        Stream.of(userNames.split(",")).map(User::new).forEach(System.out::println);

        /**
         * case3:
         * 将对象列表的某个属性单独提取为一个列表
         */
        List<User> users = Lists.newArrayList();
        users.add(new User("martin"));
        users.add(new User("job"));
        users.add(new User("miko"));
        // 转换、收集器、
        users.stream().map(User::getName).collect(Collectors.toList()).forEach(System.out::println);



    }
}

class User {
    private String name;

    public User(String str) {
        name = str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}