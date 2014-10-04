package com.dumitruc.training.ws;


import org.springframework.stereotype.Component;

/**
* Created with IntelliJ IDEA.
* User: dumitruc
* Date: 03/10/14
* Time: 23:51
* To change this template use File | Settings | File Templates.
*/
public class Person {

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String age;
    private String name;
    private String sex;

}
