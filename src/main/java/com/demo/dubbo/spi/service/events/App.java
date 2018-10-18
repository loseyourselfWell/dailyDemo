package com.demo.dubbo.spi.service.events;

/**
 * @package com.demo.dubbo.spi.service.events
 * @Author: likun
 * @Date: 2018/9/21
 */
public class App {

    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Listener listener = new Listener();
        publisher.addObserver(listener);

        publisher.publish(new WeimobEvent(new WeimobEvent.Param()));
    }

}
