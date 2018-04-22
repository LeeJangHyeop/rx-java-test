import io.reactivex.Observable;

/**
 * Created by LeeJangHyeop on 2018. 3. 28..
 */
public class ObservableTest {
    static void run() {
        Observable<String> observable = Observable.create(subscribe -> {
            Log.log("Start");
            subscribe.onNext("msg 1");
            subscribe.onNext("msg 2");
        });

        observable.subscribe(data -> Log.log("from publisher1 : " + data));
        observable.subscribe(data -> Log.log("from publisher2 : " + data));
    }
}
