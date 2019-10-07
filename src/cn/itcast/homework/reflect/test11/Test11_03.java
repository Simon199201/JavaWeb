package cn.itcast.homework.reflect.test11;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 使用java中的反射技术将类中的属性与map中的key相同名称的，使用反射技术将key对应的value值赋值给属性
 */
public class Test11_03 {
    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "tom");
        map.put("age", 20);
        map.put("sex", "男");
        map.put("address", "北京");


        Class<?> aClass = Class.forName("cn.itcast.homework.reflect.test11.Person");
        Object obj = aClass.newInstance();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Field declaredField = aClass.getDeclaredField(key);
            declaredField.setAccessible(true);
            declaredField.set(obj, map.get(key));
        }

        System.out.println(obj);
    }
}
