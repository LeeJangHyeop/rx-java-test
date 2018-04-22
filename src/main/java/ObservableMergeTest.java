import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by LeeJangHyeop on 2018. 4. 1..
 */
public class ObservableMergeTest {
    static void run() throws InterruptedException {
        Observable<String> observable1 = Observable
                .<String>create(subscriber -> {
                    subscriber.onNext("observable1 - 1");
                    subscriber.onNext("observable1 - 2");
                }).delay(5, TimeUnit.SECONDS);

        Observable<String> observable2 = Observable
                .create(subscriber -> {
                    subscriber.onNext("observable2 - 1");
                    subscriber.onNext("observable2 - 2");
                });

        Observable<String> observable3 = Observable
                .create(subscriber -> {
                    subscriber.onNext("observable3 - 1");
                    subscriber.onNext("observable3 - 2");
                });

        Observable<String> observableMerge = Observable.merge(observable1, observable2, observable3);

        observableMerge.subscribe(Log::log);
    }
}
