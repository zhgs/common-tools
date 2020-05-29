package com.zhgs.java8;

import java.util.function.*;

/**
 * 功能描述：
 *
 * @Auther: zhouguangsheng
 * @Date: 2020/3/1 10:57
 */
public class FunctionTest {

    public static void main(String[] args) {

        // Consumer(纯消费入参) 一个入参，无出参
        Consumer<String> con = s -> {
            System.out.println(s);
        };
        Consumer<String> con2 = s -> System.out.println(s);
        Consumer<Object> con3 = System.out::println;

        // function(通用函数)，一个入参，一个指定出参
        Function<String,Integer> fun1 = (String s)->{
            return Integer.parseInt(s);
        };
        Function<String,Integer> fun2 = s -> Integer.parseInt(s);
        Function<String,Integer> fun3 = Integer::parseInt;

        Integer r = fun2.apply("15");
        con3.accept(r);

        // Predicate(断言) 一个入参，返回固定的Boolean值
        Predicate<String> pre = s -> s.equals("a");
        con3.accept(pre.test("a"));

        // Supplier(供应商) 无入参，反回一个指定类型值
        Supplier<String> sup = () -> "1";
        con2.accept(sup.get());

        // UnaryOperator 出入参相同
        UnaryOperator<String> una = s -> s;
        con2.accept(una.apply("返回和入参相同类型"));
    }
}
