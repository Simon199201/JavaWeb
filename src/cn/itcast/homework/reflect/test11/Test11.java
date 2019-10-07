package cn.itcast.homework.reflect.test11;

import java.lang.reflect.Method;

public class Test11 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("cn.itcast.homework.reflect.test11.Person");
        //获取对象
        Object obj = cls.newInstance();
        //设置姓名
        cls.getMethod("setName", String.class).invoke(obj, "simon");
        //获取方法
        Method getName = cls.getMethod("getName");
        //执行obj对象的getName方法
        Object result = getName.invoke(obj);
        //输出结果
        System.out.println(result);
    }
}
