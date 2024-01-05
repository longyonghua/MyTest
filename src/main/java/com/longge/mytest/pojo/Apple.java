package com.longge.mytest.pojo;

import java.util.Arrays;

/**
 * @author longyonghua
 * @create 2023-12-14-17:52
 */
public class Apple implements Cloneable{
    public int age;
    public String name;
    public int[] array;

    @Override
    public Apple clone() {
        try {
            return (Apple) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.age = 10;
        apple.name = "小小";
        apple.array = new int[]{1,2,3};

        Apple apple2 = apple.clone();

        System.out.println(apple.age == apple2.age); //true
        System.out.println(apple.name == apple2.name); //true
        System.out.println(apple.array == apple2.array); //true

        apple2.age = 20;
        apple2.name = "谢谢";
        apple2.array[0] = 4;

        System.out.println(apple.age + "-" +apple.name + "-" + Arrays.toString(apple.array)); //10-小小-[4,2,3]
        System.out.println(apple2.age + "-" +apple2.name + "-" + Arrays.toString(apple2.array)); //20-谢谢-[4,2,3]
        System.out.println("test");
    }
}
