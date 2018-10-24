package com.example.mybatis.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 描述：
 *
 * @ClassName CaffeineConfig
 * @Author 徐旭
 * @Date 2018/10/10 13:56
 * @Version 1.0
 */
@Configuration
@EnableCaching
public class CaffeineConfig {
    private static final int DEFAULT_MAXSIZE = 10000;
    private static final int DEFAULT_TTL = 600;

    /**
     * 定义cache名称、超时时长（秒），最大容量
     * 每个cache缺省：10秒超时、最多缓存50000条数据，需要修改可以在构造方法的参数中指定
     */
    public enum Caches {

        // 有效期是600秒
        getUserById(600),
        // 有效期2个小时，最大容量1000
        listCustomers(7200, 1000);

        private int ttl = DEFAULT_TTL;
        private int maxSize = DEFAULT_MAXSIZE;

        Caches() {
        }

        Caches(int ttl) {
            this.ttl = ttl;
        }

        Caches(int ttl, int maxSize) {
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public int getTtl() {
            return ttl;
        }
    }

    /**
     * 个性化配置缓存
     * @return
     */
    @Bean
    @Primary
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ArrayList<CaffeineCache> caches = new ArrayList<>();

        // 把各个cache注册到cacheManager中，CaffeineCache实现了org.springframework.cache.Cache接口
        for (Caches c : Caches.values()) {
            caches.add(new CaffeineCache(c.name(),
                    Caffeine.newBuilder().recordStats()
                            .expireAfterWrite(c.getTtl(), TimeUnit.SECONDS)
                            .maximumSize(c.getMaxSize()).build())
            );
        }
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
