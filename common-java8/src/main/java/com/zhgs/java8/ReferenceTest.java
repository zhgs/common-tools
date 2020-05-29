package com.zhgs.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 功能描述：lamda 推导
 *
 * @Auther: zhouguangsheng
 * @Date: 2020/3/3 22:04
 */
public class ReferenceTest {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("bcd","abc","cde");
        Consumer<List<String>> consumer = System.out::println;

        consumer.accept(stringList);
        stringList.sort(Comparator.comparing(String::toString));
        consumer.accept(stringList);
    }
}
