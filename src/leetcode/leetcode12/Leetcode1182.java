package leetcode.leetcode12;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1182 {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> result=new ArrayList<>();
        int length=colors.length;

        int[][] left=new int[length][4];
        int[] cur=new int[]{-1000000,-1000000,-1000000,-1000000};
        for(int i=0;i<length;i++){
            cur[colors[i]]=i;
            left[i]=cur.clone();
        }

        int[][] right=new int[length][4];
        cur=new int[]{2000000,2000000,2000000,2000000};
        for(int j=length-1;j>=0;j--){
            cur[colors[j]]=j;
            right[j]=cur.clone();
        }

        for(int[] q:queries){
            int index=q[0];
            int search=q[1];

            if(left[index][search]==-1000000&&right[index][search]==2000000){
                result.add(-1);
            }else{
                result.add(Math.min(index-left[index][search],right[index][search]-index));
            }
        }
        return result;
    }
}
