package com.ruoyi.common.utils.uuid;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

import javax.annotation.PostConstruct;

/**
 * ID生成器工具类
 * 
 * @author ruoyi
 */
public class IdUtils
{
    private static long workerId = 0;
    private static long datacenterId = 1;
    private static Snowflake snowFlake = IdUtil.createSnowflake(workerId, datacenterId);

    /**
     * 获取随机UUID
     * 
     * @return 随机UUID
     */
    public static String randomUUID()
    {
        return UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     * 
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID()
    {
        return UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     * 
     * @return 随机UUID
     */
    public static String fastUUID()
    {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     * 
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID()
    {
        return UUID.fastUUID().toString(true);
    }


//    获取雪花ID

    public static synchronized long getSnowId() {
        return snowFlake.nextId();
    }
}
