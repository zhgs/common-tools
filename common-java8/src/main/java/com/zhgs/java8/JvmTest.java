package com.zhgs.java8;

import com.zhgs.wangwenqun.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：
 *
 * Metaspace:存放class文件，常量池
 * Eden
 * Survivor0
 * Survivor1
 *
 * @Auther: zhouguangsheng
 * @Date: 2020/3/19 15:14
 */
public class JvmTest {

    public static void main(String[] args) throws InterruptedException {

        Map<Integer,Person> map = new HashMap<>();
        List<Person> list = new ArrayList<>();
        int index = 0;
        while (true){
            Person person = new Person();
            list.add(person);
            Thread.sleep(1);
        }
    }
}
