package year2018.observerSimple;

import java.util.Observable;


/**
 * 发布者相当于主题，用来发布消息交给监听者
 */
public class ObservableForListen extends Observable {

    /**
     * 封装change和通知方法
     * @param message
     */
    public void changeMessage(String message){
        setChanged();
        /**
         * 通知监听者
         * 回调observer的update方法
         */
        notifyObservers(message);

    }
}
