package cn.itcast.homework.reflect.test11;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 通过反射技术，在这个泛型为Integer的ArrayList中存放一个String类型的对象
 */
public class Test11_04 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        Class<? extends ArrayList> cls = list.getClass();
        Method add = cls.getMethod("add", Object.class);
        add.invoke(list, "hello");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
