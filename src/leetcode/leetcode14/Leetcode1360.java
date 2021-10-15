package leetcode.leetcode14;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Leetcode1360 {

    public int daysBetweenDates(String date1, String date2) {

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            Date d1 = df.parse(date1);
            Date d2 = df.parse(date2);

            return (int) (Math.abs(d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000));
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
