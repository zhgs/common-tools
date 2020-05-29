package com.zhgs.java8.vo;
/**
 * Created by wangwenjun on 2016/10/18.
 */
public class Apple {

    private String name;
    private int weigth;

    public Apple(String name, int weigth) {
        this.name = name;
        this.weigth = weigth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public enum Type {MEAT, FISH, OTHER}


    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weigth=" + weigth +
                '}';
    }
}
