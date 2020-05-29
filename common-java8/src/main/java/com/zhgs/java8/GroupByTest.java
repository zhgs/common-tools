package com.zhgs.java8;

import com.zhgs.wangwenqun.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Desc:
 * @Author: zhouguangsheng
 * @Date: create by 2020/5/25 20:26
 * @Modify By:
 */
public class GroupByTest {



    public static void main(String[] args) {
        List<com.zhgs.wangwenqun.Dish> menu = Arrays.asList(
                new com.zhgs.wangwenqun.Dish("pork", false, 800, com.zhgs.wangwenqun.Dish.Type.MEAT),
                new com.zhgs.wangwenqun.Dish("beef", false, 700, com.zhgs.wangwenqun.Dish.Type.MEAT),
                new com.zhgs.wangwenqun.Dish("chicken", false, 400, com.zhgs.wangwenqun.Dish.Type.MEAT),
                new com.zhgs.wangwenqun.Dish("french fries", true, 530, com.zhgs.wangwenqun.Dish.Type.OTHER),
                new com.zhgs.wangwenqun.Dish("rice", true, 350, com.zhgs.wangwenqun.Dish.Type.OTHER),
                new com.zhgs.wangwenqun.Dish("season fruit", true, 120, com.zhgs.wangwenqun.Dish.Type.OTHER),
                new com.zhgs.wangwenqun.Dish("pizza", true, 550, com.zhgs.wangwenqun.Dish.Type.OTHER),
                new com.zhgs.wangwenqun.Dish("prawns", false, 300, com.zhgs.wangwenqun.Dish.Type.FISH),
                new com.zhgs.wangwenqun.Dish("salmon", false, 450, Dish.Type.FISH));
//        Map<Integer, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getCalories));
//        collect.keySet().stream().forEach(System.out::println);


        Stream<Dish> dishStream = menu.stream().filter(d -> d.getName().equals("zhgs"));
        System.out.println("......");
        Optional.ofNullable(dishStream).ifPresent(s -> s.forEach(dish -> System.out.print(dish.getName())));
        System.out.println("......");


    }
}
