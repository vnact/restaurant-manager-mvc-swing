package utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * createAt Jan 2, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class Debouncer {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final ConcurrentHashMap<Object, Future<?>> delayedMap = new ConcurrentHashMap<>();

    public void debounce(final Object key, final Runnable runnable, long delay) {
        final Future<?> prev = delayedMap.put(key, scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                } finally {
                    delayedMap.remove(key);
                }
            }
        }, delay, TimeUnit.MILLISECONDS));
        if (prev != null) {
            prev.cancel(true);
        }
    }

    public void shutdown() {
        scheduler.shutdownNow();
    }

    public static void main(String[] args) {
        Debouncer debouncer = new Debouncer();
        debouncer.debounce(Void.class, () -> {
            System.out.println("123123");
        }, 0);
        debouncer.debounce(Void.class, () -> {
            System.out.println("1231234");
        }, 300);
    }
}
