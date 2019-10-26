package com.atguigu.sh.zk.distributelock;

/**
 * @auther zzyy
 * @create 2019-10-20 21:53
 */
public interface ZkLock
{
    public void lock();
    public void unlock();
}
