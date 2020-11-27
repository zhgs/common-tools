package com.common.kafka;

import java.util.Arrays;

/**
 * @Desc:
 * @Author: zhouguangsheng
 * @Date: create by 2020/9/4 18:30
 * @Modify By:
 */
public class Test {

    public static void main(String[] args) {
        String[] splits ="".split(",");
        Arrays.asList(splits).forEach(word -> System.out.println(word));
    }
}
