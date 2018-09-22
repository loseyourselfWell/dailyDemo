package year2018.observerSimple;

import java.util.Observable;


/**
 * 监听器，负责监听发布者
 */
public class ObservableForListen extends Observable {

    /**
     * 封装change和通知方法
     * @param message
     */
    public void changeMessage(String message){
        setChanged();
        /**
         * 回调observer的update方法
         */
        notifyObservers(message);

    }
}
