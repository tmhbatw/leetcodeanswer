package leetcode.leetcode18;

public class Leetcode1736 {
    public String maximumTime(String time) {
        String[] t=time.split(":");
        return getMaxHour(t[0])+":"+getMaxMin(t[1]);
    }

    private String getMaxHour(String hour){
        if(hour.charAt(0)=='?'&&hour.charAt(1)=='?')
            return "23";
        if(hour.charAt(0)=='?'){
            if(hour.charAt(1)<='3')
                return "2"+hour.charAt(1);
            else
                return "1"+hour.charAt(1);
        }
        if(hour.charAt(1)=='?'){
            if(hour.charAt(0)=='2')
                return hour.charAt(0)+"3";
            return hour.charAt(0)+"9";
        }
        return hour;
    }

    private String getMaxMin(String min){
        if(min.charAt(0)=='?'&&min.charAt(1)=='?')
            return "59";
        if(min.charAt(0)=='?')
            return "5"+min.charAt(1);
        if(min.charAt(1)=='?')
            return min.charAt(0)+"9";
        return min;
    }
}
