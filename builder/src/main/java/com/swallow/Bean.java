package com.swallow;

/**
 * 类描述：builder设计模式
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class Bean {

    /*定义一个静态内部类Builder，内部的成员变量和外部类一样
    Builder类通过一系列的方法用于成员变量的赋值，并返回当前对象本身（this）
    Builder类提供一个build方法或者create方法用于创建对应的外部类，该方法内部调用了外部类的一个私有构造函数，该构造函数的参数就是内部类Builder
    外部类提供一个私有构造函数供内部类调用，在该构造函数中完成成员变量的赋值，取值为Builder对象中对应的值*/

    private String name;
    private int age;
    private double weight;
    private double height;
    private String address;

    /*public Bean() {
    }

    public Bean(String name, int age, double weight, double height, String address) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.address = address;
    }*/

    private Bean(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.weight = builder.weight;
        this.height = builder.height;
        this.address = builder.address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getAddress() {
        return address;
    }


    public static class Builder {

        private String name;
        private int age;
        private double weight;
        private double height;
        private String address;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }


        public Builder setAge(int age) {
            this.age = age;
            return this;
        }


        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }


        public Builder setHeight(double height) {
            this.height = height;
            return this;
        }


        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Bean build() {
            return new Bean(this);
        }
    }
}
