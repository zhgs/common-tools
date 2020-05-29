package com.zhgs.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 功能描述：
 *
 * @Auther: zhouguangsheng
 * @Date: 2020/3/6 14:19
 */
public class ArrayListTest {


    public static void main(String[] args) {
       /* List<String> list = Arrays.asList("a","b","c");
        Iterator<String> it = list.iterator();
        it.forEachRemaining(System.out::println);*/


        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> it = list.iterator();

//        while (it.hasNext()){
//            if(it.next().equals("b")){
//                it.remove();
//            }
//        }
//        System.out.println(list);

        it.forEachRemaining(s->{
            if(s.equals("b")){
                it.remove();
            }
        });
    }
}
