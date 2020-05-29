package com.zhgs.java8;

import com.zhgs.java8.vo.Dish;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @Auther: zhouguangsheng
 * @Date: 2020/3/4 10:23
 */
public class StreamTest2 {

    // 打印卡路里小于400的食物名称,按卡路里排序后打印出来
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        Consumer<Object> print = System.out::println;
        print.accept(menu);
        // 传统方法
        List<Dish> lessCalories = new ArrayList<>();
        List<String> lessCalorieNames = new ArrayList<>();
        for (Dish dish:menu){
            if(dish.getCalories()<400){
                lessCalories.add(dish);
            }
        }
        // sort
        // Collections.sort(lessCalories, (d1,d2) -> Integer.compare(d1.getCalories(),d2.getCalories()));
        Collections.sort(lessCalories, Comparator.comparing(Dish::getCalories));
        print.accept(menu);

        lessCalorieNames = getCalorieNames(lessCalories);
        print.accept(lessCalorieNames);

        // java8 stream 倒序
        List<String>newNames = menu.stream().filter(d->d.getCalories()<400).sorted((d1,d2) -> Integer.compare(d2.getCalories(),d1.getCalories())).map(Dish::getName).collect(Collectors.toList());
        print.accept(newNames);

        // java8 stream 倒序 并行
        List<String>newNames2 = menu.parallelStream().filter(d->d.getCalories()<400).sorted((d1,d2) ->
            {
                try {
                    // jconsole 验证Forkjoin线程
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                print.accept("线程执行结束");
                return Integer.compare(d2.getCalories(),d1.getCalories());
            }
        ).map(Dish::getName).collect(Collectors.toList());
        print.accept(newNames2);



    }

    private static List<String> getCalorieNames(List<Dish> lessCalories) {
        List<String> names = new ArrayList<>();
        for(Dish dish : lessCalories){
            names.add(dish.getName());
        }
        return names;
    }
}
