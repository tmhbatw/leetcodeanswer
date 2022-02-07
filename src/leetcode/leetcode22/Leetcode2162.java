package leetcode.leetcode22;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Leetcode2162 {

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int min=targetSeconds/60;
        int second=targetSeconds%60;

        int result=getCost(startAt,moveCost,pushCost,min,second);
        min--;
        second+=60;
        if(min<0||second>=100)
            return result;
        result=Math.min(result,getCost(startAt,moveCost,pushCost,min,second));
        return result;
    }

    private int getCost(int startAt,int moveCost,int pushCost,int min,int second){
        if(min>=100){
            return Integer.MAX_VALUE;
        }
        List<Integer> list=new ArrayList<>();
        if(min>=10){
            list.add(min/10);
        }
        if(min>0)
            list.add(min%10);

        if(min>0||second>=10)
            list.add(second/10);
        list.add(second%10);

        int result=0;
        for(int num:list){
            if(startAt!=num){
                result+=moveCost;
                startAt=num;
            }
        }

        return result+list.size()*pushCost;
    }
}
