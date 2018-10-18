package com.demo.dubbo.spi.service.events;

import java.util.EventObject;

/**
 * @package com.demo.dubbo.spi.service.events
 * @Author: likun
 * @Date: 2018/9/21
 */
public class WeimobEvent extends EventObject {

    public WeimobEvent (Param param) {
        super(param);
    }

    static class Param {}

}
