
import java.util.Calendar;

/**
 * createAt Jan 4, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class Demo5 {

    public static void main(String[] args) {
        RenderCalendar(Calendar.getInstance());
    }

    public static void RenderCalendar(Calendar cal) {
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int month = cal.get(Calendar.MONTH) + 1;
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int i, j;
        for (i = 1; i < dayOfWeek; i++) {
            System.out.print("_ ");
        }
        for (j = 1; j <= maxDay; j++) {
            System.out.print(j + " ");
            if ((j + i) % 7 == 0) {
                System.out.println("");
            }
        }
    }
}
