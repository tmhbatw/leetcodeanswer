package leetcode5;

import java.util.ArrayList;
import java.util.List;

public class Leetcode401 {
    /*Description
    * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
    * 每个 LED 代表一个 0 或 1，最低位在右侧。
    * */


    public List<String> readBinaryWatch(int num) {
        int[] hour=new int[]{1,2,4,8};
        int[] min=new int[]{1,2,4,8,16,32};
        List<String> result=new ArrayList<>();
        for(int i=0;i<=Math.min(3,num);i++){
            if(num-i>6)
                continue;
            List<Integer> h=new ArrayList<>();
            getReachedTime(i,0,0,h,hour,11);
            List<Integer> m=new ArrayList<>();
            getReachedTime(num-i,0,0,m,min,59);
            for(int curHour:h){
                for(int curMin:m) {
                    result.add(curHour + ":" + (curMin<10?'0'+curMin:curMin));
                }
            }
        }
        return result;
    }

    private void getReachedTime(int number,int curSum,int index,List<Integer> list,int[] num,int max){
        if(number==0){
            if(curSum<=max)
                list.add(curSum);
            return;
        }
        for(int i=index;i<num.length;i++){
            getReachedTime(number-1,curSum+num[i],i+1,list,num,max);
        }
    }

}
