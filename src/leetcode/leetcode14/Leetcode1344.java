package leetcode.leetcode14;

public class Leetcode1344 {

    public double angleClock(int hour, int minutes) {
        double m=minutes*1.0/60*360;

        hour=hour==12?0:hour;
        double h=(hour+minutes*1.0/60)/12*360;

        System.out.println(m+" "+h);
        double res= Math.abs(m-h);
        return Math.min(res,360-res);
    }
}
