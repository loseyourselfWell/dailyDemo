package year2018.observerSimple;

/**
 * 观察者模式测试类
 */
public class ObservableTest {

    public static void main(String[] args) {
        ObservableForListen observableForListen = new ObservableForListen();
        AppForNotified appForNotified = new AppForNotified();
        String message = "lk";
        observableForListen.addObserver(appForNotified);
        // 主题改变通知观察者
        observableForListen.changeMessage(message);
    }
}
