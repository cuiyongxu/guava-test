package com.google.common.cache

import com.ijson.groovy.entity.Client
import spock.lang.Specification

import java.util.concurrent.TimeUnit

/**
 * guava缓存过期时间分为两种，一种是从写入时开始计时，一种是从最后访问时间开始计时，而且guava缓存的过期时间是设置到整个一组缓存上的；
 * 这和EHCache，redis，memcached等不同，这些缓存系统设置都将缓存时间设置到了单个缓存上。guava缓存设计成了一组对象一个缓存实例，这样
 * 做的好处是一组对象设置一组缓存策略，你可以根据不同的业务来设置不同的缓存策略，包括弱引用，软引用，过期时间，最大项数等。另外一点好处是
 * 你可以根据不同的组来统计缓存的命中率，这样更有意义一些。
 *
 * 这样做也是有缺点的，缺点是首先是每个缓存组都需要声明不同的缓存实例，具体到业务程序中可能就是每个业务对象一个缓存了。这样就把不同的业务缓存分散到不同的业务系统中了，不太好管理。
 * Created by cuiyongxu on 17/6/20.
 */
class GuavaCacheTest extends Specification {

    def "缓存的使用"() {
        given:
        //缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        LoadingCache<Integer, Client> userLoadingCache =
                //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
                CacheBuilder.newBuilder()
                //设置并发级别为8，并发级别是指可以同时写缓存的线程数
                        .concurrencyLevel(8)
                //设置写缓存后8秒钟过期
                        .expireAfterAccess(8, TimeUnit.SECONDS)
                //设置缓存容器的初始容量为10
                        .initialCapacity(10)
                //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                        .maximumSize(100)
                //设置要统计缓存的命中率
                        .recordStats()
                //设置缓存的移除通知
                        .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    void onRemoval(RemovalNotification<Object, Object> notification) {
                        println "[ " + notification.getKey() + " ]已被删除,原因:[ " + notification.getCause() + " ]";
                    }
                })
                //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                //TODO 为什么load单独 放出来,而不是乐死maximumSize(10)
                        .build(new CacheLoader<Integer, Client>() {
                            @Override
                            Client load(Integer key) throws Exception {

                                return new Client(key, UUID.randomUUID().toString(), new Random().nextInt(100));
                            }
                        })
        for (int i = 0; i < 20; i++) {
            //从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
            Client user = userLoadingCache.get(i);
            println user.toString()
            //休眠1秒
            TimeUnit.SECONDS.sleep(1);
        }
        println userLoadingCache.asMap().size()

        //最后打印缓存的命中率等 情况
        println userLoadingCache.stats().toString()
    }
}
