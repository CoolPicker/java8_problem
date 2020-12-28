package com.test;

import redis.clients.jedis.Jedis;

/**
 * @Description redis实现分布式锁 TODO
 * @Author nya
 * @Date 2020/6/23 下午4:23
 **/
public class DistributedLockRedisTest {

    public static void redisGetLock(Jedis jedis,String localKey,int expireTime) {
        long expires = System.currentTimeMillis() + expireTime;
        String expiresStr = String.valueOf(expires);
        // setnx获取当前锁
        if (jedis.setnx(localKey,expiresStr) == 1) {
            // 获取锁

            // ... 原子操作

            // 释放锁
            jedis.del(localKey);
        } else {
            // 判断死锁 不能用get,必须用getset,保证原子操作
            String currentValueStr = jedis.get(localKey);
            if (currentValueStr != null && Long.parseLong(currentValueStr) < expires) {
                String oldValueStr = jedis.getSet(localKey, expiresStr);
                if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                    // 发生死锁,自动获取锁

                    // ... 原子操作

                    // 释放锁
                    jedis.del(localKey);
                }
            } else {
                // 未发生死锁, 等待
            }
        }
    }

}
