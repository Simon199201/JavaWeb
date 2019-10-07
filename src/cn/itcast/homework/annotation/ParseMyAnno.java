package cn.itcast.homework.annotation;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义三个注解：@MyTest，@MyBefore，@MyAfter，分别模拟JUnit中的@Test，@Before，@After三个注解的作用，并测试使用
 * <p>
 * 注意:
 * <p>
 * 1:定义三个注解：@MyTest， @MyBefore，@MyAfter，无需任何属性，要求三个注解均只能用在方法上，而且作用域范围在运行时.
 * <p>
 * 2:定义一个注解解析类ParseMyAnno，并定义方法parse()，
 * <p>
 * 方法中：反射解析注解，先运行@MyBefore的方法，
 * <p>
 * 然后运行@MyTest的方法，最后运行@MyAfter的方法
 */
public class ParseMyAnno {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Student student = new Student();
        Class<? extends Student> cls = student.getClass();
        Method[] methods = cls.getMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(MyTest.class)) {
                for (Method m2 : methods) {
                    if (m2.isAnnotationPresent(MyBefore.class)) {
                        m2.invoke(student);
                    }
                }
                m.invoke(student);
            }
        }
    }
}
