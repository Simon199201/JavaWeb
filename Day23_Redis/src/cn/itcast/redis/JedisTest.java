package cn.itcast.redis;

import cn.itcast.redis.uitl.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    @Test
    public void test1() {
        Jedis jedis = new Jedis();
        jedis.set("school", "zuchongzhi");
        System.out.println(jedis.get("school"));
        jedis.close();
    }

    @Test
    public void test2() {
        Jedis jedis = new Jedis();
        jedis.hset("user", "name", "wangwu");
        jedis.hset("user", "password", "maliu");
        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keys = user.keySet();
        for (String key : keys) {
            System.out.println("key is : " + key + "\t value is : " + user.get(key));
        }
        jedis.close();
    }

    @Test
    public void test3() {
        Jedis jedis = new Jedis();
        jedis.del("worker1");
        jedis.lpush("worker1", "name", "wangwu");
        jedis.rpush("worker1", "name1", "wangwu1");
        String delWorker = jedis.rpop("worker1");
        List<String> worker1 = jedis.lrange("worker1", 0, -1);
        System.out.println("delWorker is " + delWorker);
        for (String key : worker1) {
            System.out.println("key is : " + key);
        }
        jedis.close();
    }
    @Test
    public void test4(){
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("temp1", "aaa");
        System.out.println(jedis.get("temp1"));
        jedis.close();

    }
}
