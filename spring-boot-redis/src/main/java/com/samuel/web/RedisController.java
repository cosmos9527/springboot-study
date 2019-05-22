package com.samuel.web;

import com.alibaba.fastjson.JSON;
import com.samuel.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 存储字符串
     * @param name
     * @param value
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(String name,String value){
        try{
            redisUtils.set(name,value,0);
            return name + ":" + value + " 存储成功!";
        }catch (Exception e){
            return "发生异常了!";
        }
    }

    @GetMapping("/get")
    @ResponseBody
    public String get(String key){
        return redisUtils.get(key,0);
    }
}
