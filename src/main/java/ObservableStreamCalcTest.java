import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static io.reactivex.Observable.timer;

/**
 * Created by LeeJangHyeop on 2018. 3. 29..
 */
public class ObservableStreamCalcTest {
    static void run() throws InterruptedException {
        Observable
                .just("a", "bc", "def", "ghij")
                .flatMap(string -> timer(string.length(), TimeUnit.SECONDS).map(x -> string + "!"))
                .subscribe(Log::log);

        TimeUnit.SECONDS.sleep(15);
    }
}
