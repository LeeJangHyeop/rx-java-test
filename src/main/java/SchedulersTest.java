import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.reactivex.Observable;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by LeeJangHyeop on 2018. 4. 1..
 */
public class SchedulersTest {
    static void run() {
        ExecutorService poolA = Executors.newFixedThreadPool(10, threadFactory("Sched-A-%d"));

        ExecutorService poolB = Executors.newFixedThreadPool(10, threadFactory("Sched-B-%d"));

        ExecutorService poolC = Executors.newFixedThreadPool(10, threadFactory("Sched-C-%d"));

        RxGroceries rxGroceries = new RxGroceries();
    }

    static ThreadFactory threadFactory(String pattern) {
        return new ThreadFactoryBuilder()
                .setNameFormat(pattern)
                .build();

    }

    static class RxGroceries {
        Observable<BigDecimal> purchase(String prodctName, int quantity) {
            return Observable.fromCallable(() -> doPurchase(prodctName, quantity));
        }

        static BigDecimal doPurchase(String productName, int quantity) {
            Log.log("Purchasing " + quantity + ", " + productName);
            BigDecimal bigDecimal = BigDecimal.valueOf(100 * quantity);
            Log.log("Done " + quantity + ", " + productName);
            return bigDecimal;
        }
    }
}
