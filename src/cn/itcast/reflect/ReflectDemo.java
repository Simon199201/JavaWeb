package cn.itcast.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 写一个框架，帮我创建任意类，并执行其中任意方法
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //获取文件内容
        Properties properties = new Properties();
        File file = new File("props.txt");
        properties.load(new FileInputStream(file));

        Class<?> aClass = Class.forName(properties.getProperty("class"));
        Object obj = aClass.newInstance();
        Method method = aClass.getMethod(properties.getProperty("method"));
        method.invoke(obj);
    }
}
