package year2018.observerSimple;

public class ObservableTest {

    public static void main(String[] args) {
        ObservableForListen observableForListen = new ObservableForListen();
        AppForNotified appForNotified = new AppForNotified();
        String message = "lk";
        observableForListen.addObserver(appForNotified);
//        appForNotified.update(observableForListen,message);
        observableForListen.changeMessage(message);
    }
}
