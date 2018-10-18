package com.demo.dubbo.spi.service.events;

import java.util.Observable;

/**
 * @package com.demo.dubbo.spi.service.events
 * @Author: likun
 * @Date: 2018/9/21
 */
public class Publisher extends Observable {

    public void publish (WeimobEvent event) {
        setChanged();
        notifyObservers(event);
    }

}
