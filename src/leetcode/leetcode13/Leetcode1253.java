package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum= Arrays.stream(colsum).sum();
        if(sum!=upper+lower)
            return new ArrayList<>();

        int[][] num=new int[2][colsum.length];
        int twoTime = 0;
        for(int i=0;i<colsum.length;i++){
            if(colsum[i]==2){
                twoTime++;
                num[0][i]=num[1][i]=1;
            }
        }

        if(twoTime>upper||twoTime>lower)
            return new ArrayList<>();
        for(int i=0;i<colsum.length;i++){
            if(colsum[i]==1){
                if(upper>twoTime){
                    num[0][i]=1;
                    upper--;
                }else{
                    num[1][i]=1;
                }
            }
        }

        List<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for(int i=0;i<num[0].length;i++){
            result.get(0).add(num[0][i]);
            result.get(1).add(num[1][i]);
        }

        return result;
    }


}
