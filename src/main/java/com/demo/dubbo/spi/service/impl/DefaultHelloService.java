package com.demo.dubbo.spi.service.impl;

import com.demo.dubbo.spi.service.HelloService;

/**
 * SPI 接口实现类
 * @author likun
 * @version V1.0
 * @Title: com.demo.dubbo.spi.service.impl
 * @date 2018/3/22 16:47
 */
public class DefaultHelloService implements HelloService {
    @Override
    public void hello() {
        System.out.println("DefaultHelloService hello");
    }
}
