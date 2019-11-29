package cn.itcast.service.impl;

import cn.itcast.dao.ProvinceDao;
import cn.itcast.dao.impl.ProvinceDaoImpl;
import cn.itcast.domain.ProvinceBean;
import cn.itcast.redis.uitl.JedisPoolUtils;
import cn.itcast.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    @Override
    public String getAllJson() {
        //1.1获取jedis
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        //2.1获取redis缓存，如果为空，则去数据库读取，然后写入redis
        if (province_json == null || province_json.equals("")) {
            ProvinceDao dao = new ProvinceDaoImpl();
            List<ProvinceBean> list = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province", province_json);
            System.out.println("没有缓存...");
        } else {
            System.out.println("有缓存...");
        }
        jedis.close();

        return province_json;
    }
}
