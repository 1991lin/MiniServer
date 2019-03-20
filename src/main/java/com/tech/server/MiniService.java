package com.tech.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: MiniServer
 * @author: Eric
 * @create: 2019-03-18 22:55
 **/
public class MiniService {


    private final static Logger logger = LoggerFactory.getLogger(MiniService.class);

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            20,
            10,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new MiniThreadFactory()
            , new ThreadPoolExecutor.CallerRunsPolicy()
    );


    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }


    public void submitJob(Runnable job) {
        threadPoolExecutor.execute(job);
    }


}
