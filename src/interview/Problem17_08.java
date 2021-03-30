package interview;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem17_08 {
    /*Description
    * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，
    * 在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人
    * */

    public int bestSeqAtIndex(int[] height, int[] weight) {
        int number=height.length;
        if(number==0)
            return 0;
        int[][] dp=new int[number][2];
        for(int i=0;i<number;i++){
            dp[i][0]=height[i];
            dp[i][1]=weight[i];
        }
        Arrays.sort(dp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });
        List<Integer> result=new ArrayList<>();
        result.add(dp[0][1]);
        for(int i=1;i<number;i++){
            if(dp[i][1]>result.get(result.size()-1)){
                result.add(dp[i][1]);
            }else{
                int left=0,right=result.size()-1;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    System.out.println(mid);
                    int val=result.get(mid);
                    if(val>=dp[i][1]&&(mid==0||result.get(mid-1)<dp[i][1])){
                        result.set(mid,dp[i][1]);
                        break;
                    }
                    else if(val<dp[i][1]){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
            }
        }
        return result.size();
    }

    public static void main(String[] args){
        int[] height=new int[]{1,2,3,4};
        int[] weight=new int[]{4,3,2,1};
        System.out.println(new Problem17_08().bestSeqAtIndex(height,weight));
    }


}
