package com.bmpproxy;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.jupiter.api.Test;


public class BMPTest {

    @Test
    void start() throws InterruptedException {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        //开启的端口即为代理端口
        proxy.start(8082);
        int port = proxy.getPort(); // get the JVM-assigned port
        // Selenium or HTTP client configuration goes here
        //最常使用的两个方法
        //proxy.addRequestFilter();
        //proxy.addResponseFilter();


        Thread.sleep(50000);
        System.out.println(port);
    }

}
