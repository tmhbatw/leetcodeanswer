package leetcode3;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode248 {
    /*Description
    *中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
    * 写一个函数来计算范围在 [low, high] 之间中心对称数的个数。
    * */

    String low;
    String high;
    Queue<String> q;
    int[] dp1=new int[]{0,1,6,8,9};
    int[] dp2=new int[]{0,1,9,8,6};
    public int strobogrammaticInRange(String low, String high) {
        this.low=low;
        this.high=high;
        int result=0;
        q=new LinkedList<>();
        q.add("");
        q.add("0");
        q.add("1");
        q.add("8");
        while(!q.isEmpty()){
            String cur=q.poll();
            if(cur.length()>high.length())
                continue;
            if(isValid(cur)){
                if(cur.length()==1||cur.charAt(0)!='0')
                    result++;
            }
            addString(cur);
        }
        return result;
    }

    private void addString(String cur){
        for(int i=0;i<5;i++)
            q.add(dp1[i]+cur+dp2[i]);
    }

    private boolean isValid(String cur){
        return (cur.length()>low.length()||(cur.length()==low.length())&&cur.compareTo(low)>=0)&&
                (cur.length()<high.length()||cur.length()<=high.length()&&cur.compareTo(high)<=0);
    }
}
