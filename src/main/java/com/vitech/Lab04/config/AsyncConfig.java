package com.vitech.Lab04.config;


import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
public class AsyncConfig {


    @Bean(name = "taskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(8);
        executor.setCorePoolSize(4);
        executor.setThreadNamePrefix("ProductRegistryThread-");
        return null;
    }
}
