package com.demo.dubbo.spi.service.events;

import java.util.Observable;
import java.util.Observer;

/**
 * @package com.demo.dubbo.spi.service.events
 * @Author: likun
 * @Date: 2018/9/21
 */
public class Listener implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg.getClass().getName());
    }



}
