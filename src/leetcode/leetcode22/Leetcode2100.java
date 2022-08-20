package leetcode.leetcode22;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2100 {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> result=new ArrayList<>();
        int[] left=new int[security.length];
        int count=0;
        for(int i=1;i<security.length;i++){
            if(security[i]<=security[i-1]){
                count++;
            }else{
                count=0;
            }
            left[i]=count;
        }

        int[] right=new int[security.length];
        count = 0;
        for(int j=security.length-2;j>=0;j--){
            if(security[j]<=security[j+1])
                count++;
            else
                count=0;
            right[j]=count;
        }

        for(int i=0;i<security.length;i++){
            if(left[i]>=time&&right[i]>=time)
                result.add(i);
        }

        return result;
    }
}
