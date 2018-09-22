package year2018.observerSimple;

import java.util.Observable;
import java.util.Observer;

/**
 * 被监听的对象，当有改变时通知监听者
 */
public class AppForNotified implements Observer {

    /**
     * 改变的内容，在监听者notifyObservers方法中调用
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {

        System.out.println("app changed :"+arg);
    }
}
