package com.zhgs.java8.inteface;

/**
 * 功能描述：
 *
 * @Auther: zhouguangsheng
 * @Date: 2020/2/29 21:35
 */
public class Demo1 implements IDemo {

    @Override
    public void nomalMethod() {
        System.out.println("我是普通方法子实现");
        IDemo.super.defaultMethod(":我是参数1");
        IDemo.statMethod();
    }


    public static void main(String[] args) {
        IDemo demo1 = new Demo1();
        demo1.nomalMethod();
        demo1.defaultMethod(":我是参数12");

        IDemo.statMethod();
    }

    @Override
    public void defaultMethod(String str) {
        System.out.println("我是默认方法子实现");
    }
}
