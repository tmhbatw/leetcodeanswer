package forOffer;

import java.util.ArrayList;
import java.util.List;

public class forOffer57_2 {
    /*Description
    * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
    * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
    * */

    public int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        for(int i=1;i<=target/2;i++){
            int curSum=i;
            int start=i;
            int[] cur=new int[2];
            cur[0]=start;
            while(curSum<target){
                curSum+=++start;
            }
            if(curSum==target){
                cur[1]=start;
                res.add(cur);
            }
        }
        int[][] result=new int[res.size()][];
        for(int i=0;i<result.length;i++){
            int start=res.get(i)[0],end=res.get(i)[1];
            result[i]=new int[end-start+1];
            for(int j=start;j<=end;j++){
                result[i][j-start]=j;
            }
        }
        return result;
    }

}
