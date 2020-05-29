package com.zhgs.java8;

import com.zhgs.java8.vo.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 功能描述：
 *
 * @Auther: zhouguangsheng
 * @Date: 2020/3/5 13:41
 */
public class MapTest {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("a",300),new Apple("b",300));

        // map 返回一个Stream<R>
        list.stream().map(Apple::getName).forEach(System.out::println);
        System.out.println("-----------");

        // flatmap
        String[] strings = new String[]{"Hello","World"};
        Stream<String[]> stream = Arrays.stream(strings).map(s -> s.split(""));

        // flatmap 汇总成一个stream
        Stream<String> stringStream = stream.flatMap(strings1 -> {
            return Arrays.stream(strings1);
        });

        stringStream.distinct().forEach(System.out::println);
    }
}
