package year2018.RateLimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @package year2018.RateLimit
 * @Author: likun
 * @Date: 2018/10/19
 */
public class RateDemo {

    final RateLimiter rateLimiter = RateLimiter.create(2.0);

    void submitTasks(List<Runnable> tasks , Executor executor) {
        for (Runnable task : tasks) {
            rateLimiter.acquire();
            executor.execute(task);
        }
    }
}
