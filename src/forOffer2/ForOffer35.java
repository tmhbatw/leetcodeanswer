package forOffer2;

import java.util.List;

public class ForOffer35 {
    public int findMinDifference(List<String> timePoints) {
        timePoints.sort((o1,o2)->{
            return getMinute(o1)-getMinute(o2);
        });
        int result=getMinute(timePoints.get(0))+1440-getMinute(timePoints.get(timePoints.size()-1));
        for(int i=1;i<timePoints.size();i++)
            result=Math.min(getMinute(timePoints.get(i))-getMinute(timePoints.get(i-1)),result);
        return result;
    }



    private int getMinute(String time){
        String[] t=time.split(":");
        int hour=Integer.parseInt(t[0]);
        int min=Integer.parseInt(t[1]);
        return 60*hour+min;
    }
}
