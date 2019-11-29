package cn.itcast.redis.uitl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtils {
    private static JedisPool mJedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        InputStream is = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
            String maxTotal = prop.getProperty("maxTotal");
            String maxIdle = prop.getProperty("maxIdle");
            String host = prop.getProperty("host");
            String port = prop.getProperty("port");
            jedisPoolConfig.setMaxTotal(Integer.parseInt(maxTotal));
            jedisPoolConfig.setMaxIdle(Integer.parseInt(maxIdle));
            mJedisPool = new JedisPool(jedisPoolConfig,host, Integer.parseInt(port));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static Jedis getJedis() {
        return mJedisPool.getResource();
    }
}
