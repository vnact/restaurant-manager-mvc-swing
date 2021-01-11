package controllers;

import java.util.Timer;
import java.util.TimerTask;
import main.SessionManager;

/**
 * createAt Jan 11, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class TimeCouterController {

    static Timer timer;

    public interface Callback {

        public abstract void onTick(int second);
    }

    public static void start(Callback cb) {
        stop();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long startTime = SessionManager.getSession().getStartTime().getTime();
                int elapsedTimeMillis = (int) (System.currentTimeMillis() - startTime);
                int elapsedTimeSec = elapsedTimeMillis / 1000;
                cb.onTick(elapsedTimeSec);
            }
        }, 1000, 1000);
    }

    public static void stop() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public static void main(String[] args) {
        TimeCouterController.start(evt -> System.out.println(evt));
        System.out.println("Het");
    }
}
