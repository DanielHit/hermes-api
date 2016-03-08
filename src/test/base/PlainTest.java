package base;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Daniel on 3/7/16.
 */
public class PlainTest {
    public static void main(String[] args) {
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateResult = dayAddAndSub(Calendar.DATE, -1);
        String currentTime = sdf.format(dateResult);
        System.out.println(currentTime);

    }

    public static Date dayAddAndSub(int currentDay,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(currentDay, day);
        Date startDate = calendar.getTime();
        return startDate;
    }

}
