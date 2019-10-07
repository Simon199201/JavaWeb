package cn.itcast.homework.annotation;

public class Student {
    @MyTest
    public void show1() {
        System.out.println("show1");
    }

    @MyBefore
    public void show2() {
        System.out.println("show2");
    }

    @MyBefore
    public void show3() {
        System.out.println("show3");
    }

    @MyAfter
    public void show4() {
        System.out.println("show4");
    }
}

