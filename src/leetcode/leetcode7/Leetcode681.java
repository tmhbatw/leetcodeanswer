package leetcode.leetcode7;

import java.util.HashSet;
import java.util.Set;

public class Leetcode681 {
    /*Description
    * 给定一个形如 “HH:MM” 表示的时刻，利用当前出现过的数字构造下一个距离当前时间最近的时刻。每个出现数字都可以被无限次使用。
    * 你可以认为给定的字符串一定是合法的。例如，“01:34” 和 “12:09” 是合法的，“1:34” 和 “12:9” 是不合法的。
    * */

    public String nextClosestTime(String time) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<5;i++)
            set.add(time.charAt(i));
        time=addTime(time);
        while(!isMatch(time,set)){
            time=addTime(time);
        }
        return time;
    }

    private boolean isMatch(String time,Set<Character> set){
        for(int i=0;i<5;i++){
            if(!set.contains(time.charAt(i)))
                return false;
        }
        return true;
    }

    private String addTime(String time){
        String[] t=time.split(":");
        String min=t[1];
        if(min.equals("59"))
            return addHour(t[0])+":"+"00";
        return t[0]+":"+addMinute(t[1]);
    }

    private String addHour(String hour){
        if(hour.equals("23"))
            return "00";
        if(hour.charAt(1)=='9')
            return (char)(hour.charAt(0)+1)+""+"0";
        return hour.charAt(0)+""+(char)(hour.charAt(1)+1);
    }

    private String addMinute(String min){
        if(min.charAt(1)=='9')
            return (char)(min.charAt(0)+1)+""+'0';
        return min.charAt(0)+""+(char)(min.charAt(1)+1);
    }

    public static void main(String[] args){
        String min="05";
        System.out.println(new Leetcode681().addHour(min));

    }
}
