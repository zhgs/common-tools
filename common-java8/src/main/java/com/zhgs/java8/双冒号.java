package com.zhgs.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 功能描述：
 *
 * @Auther: zhouguangsheng
 * @Date: 2020/2/29 21:09
 */
public class 双冒号 {
    public static void  printValur(String str){
        System.out.println("print value : "+str);
    }

    public static void main(String[] args) {
        List<String> al = Arrays.asList("a", "b", "c", "d");
        al.forEach(双冒号::printValur);
        //下面的方法和上面等价的
        Consumer<String> methodParam = 双冒号::printValur; //方法参数
        al.forEach(x -> methodParam.accept(x));//方法执行accept
    }
}
