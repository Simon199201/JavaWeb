package cn.itcast.test;

import cn.itcast.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    //所有测试方法，调用之前会走init方法
    @Before
    public void init() {
        System.out.println("init...");
    }

    @Test
    public void testAdd() {
        System.out.println("我是来测试加法的");
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 5);
        System.out.println("result is " + result);
    }

    @Test
    public void testSub() {
        System.out.println("我是来测试减法的");
        Calculator calculator = new Calculator();
        int result = calculator.sub(5, 1);
        System.out.println("result is " + result);

        //断言操作来处理结果
        Assert.assertEquals(4, result);
    }
    //所有测试方法，调用之后会走close方法
    @After
    public void after() {
        System.out.println("close...");
    }
}
