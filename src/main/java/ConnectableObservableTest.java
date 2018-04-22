import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

/**
 * Created by LeeJangHyeop on 2018. 3. 28..
 */
public class ConnectableObservableTest {
    static void run() throws InterruptedException {
        ConnectableObservable<String> observable = Observable.<String>create(subscribe -> {
            Log.log("Start");
            subscribe.onNext("msg 1");
            subscribe.onNext("msg 2");
            subscribe.onComplete();
        }).publish();

        observable.subscribe(data -> Log.log("from publisher1 : " + data));
        observable.subscribe(data -> Log.log("from publisher2 : " + data));
        observable.subscribe(data -> Log.log("from publisher3 : " + data));
        observable.connect();
    }
}
