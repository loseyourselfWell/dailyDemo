package com.demo.dubbo.spi.service;

import java.util.ServiceLoader;

/**
 * jdk SPI 扩展机制
 * @author likun
 * @version V1.0
 * @Title: com.demo.dubbo.spi.service
 * @date 2018/3/22 16:49
 */
public class TestService {

    public static void main(String[] args) {
        //通过jdk自带的ServiceLoader获取META-INF下面的文件信息
        ServiceLoader<HelloService> helloServiceLoader= ServiceLoader.load(HelloService.class);
        //循环得到HelloService的实现类
        for(HelloService item:helloServiceLoader){
            item.hello();
        }
    }
}
