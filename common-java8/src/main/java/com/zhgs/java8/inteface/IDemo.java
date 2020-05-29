package com.zhgs.java8.inteface;

/**
 * 功能描述：
 *
 * @Auther: zhouguangsheng
 * @Date: 2020/2/29 21:33
 */
public interface IDemo {

    default void defaultMethod(String str){
        System.out.println("我是接口默认方法"+str);
    }

    static void statMethod(){
        System.out.println("我是静态方法");
    }

    // 我是普通方法
    void nomalMethod();
}
