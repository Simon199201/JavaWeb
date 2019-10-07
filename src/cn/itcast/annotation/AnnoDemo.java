package cn.itcast.annotation;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 写一个框架，帮我创建任意类，并执行其中任意方法
 */
@Anno(className = "cn.itcast.annotation.Student", method = "learn")
public class AnnoDemo {
    public static void main(String[] args) throws Exception {
        //获取文件内容
//        Properties properties = new Properties();
//        File file = new File("props.txt");
//        properties.load(new FileInputStream(file));
        Class<AnnoDemo> annoDemoClass = AnnoDemo.class;
        Anno annotation = annoDemoClass.getAnnotation(Anno.class);
        String className = annotation.className();
        String method1 = annotation.method();
        System.out.println(className);
        System.out.println(method1);
        Class<?> aClass = Class.forName(className);
        Object obj = aClass.newInstance();
        Method method = aClass.getMethod(method1);
        method.invoke(obj);
    }
}
