package leetcode.leetcode15;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> result=new ArrayList<>();

        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(getRes(j,i)!=1){
                    result.add(i+"/"+j);
                }
            }
        }
        return result;
    }

    private int getRes(int max, int min){
        if(max%min==0)
            return min;
        return getRes(min,max%min);
    }
}
