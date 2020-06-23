package com.common.kafka;

import java.io.Serializable;

/**
 * @Desc:
 * @Author: zhouguangsheng
 * @Date: create by 2020/6/23 16:59
 * @Modify By:
 */
public class User implements Serializable {

    private String name;
    private Integer age;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

}
