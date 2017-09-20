package test.tomcatSocket;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.coyote.http11.Http11Protocol;

//启动一个http 协议的 8000端口服务

public class TomcatMainV2
{
    public static void main(String[] args) throws Exception
    {
        Http11Protocol protocol = new Http11Protocol();
        protocol.setPort(8000);
        ThreadPoolExecutor threadPoolExecutor = createThreadPoolExecutor();
      //启动核心线程，使其处于等待工作的空闲状态。
        threadPoolExecutor.prestartCoreThread();
        protocol.setExecutor(threadPoolExecutor);
        protocol.setAdapter(new MyHandler());
        protocol.init();
        protocol.start();
    }

    public static ThreadPoolExecutor createThreadPoolExecutor()
    {
        int corePoolSize = 2;
        int maximumPoolSize = 10;
        long keepAliveTime = 60;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        return threadPoolExecutor;
    }
}
