package utils;

/**
 * createAt Dec 28, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class IntervalIncrease {

    public interface Callback {

        public abstract void run(int value);
    }

    public static void create(int num, int time, int timePerStep, Callback callback) {
        int numStep = time / timePerStep;
        int step = num / numStep;
        new Thread(() -> {
            try {
                for (int i = 0; i < num + step; i += step) {
                    callback.run(Math.min(i, num));
                    Thread.sleep(timePerStep);
                }
            } catch (Exception e) {
                callback.run(step);
            }
        }).start();
    }
}
