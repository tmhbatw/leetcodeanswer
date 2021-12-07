package leetcode.leetcode19;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1868 {


    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result=new ArrayList<>();
        int i=0,j=0;

        while(i<encoded1.length&&j<encoded2.length){
            int curVal=encoded1[i][0]*encoded2[j][0];
            int time=Math.min(encoded1[i][1],encoded2[j][1]);

            int size=result.size();
            if(size>0&&result.get(size-1).get(0)==curVal){
                result.get(size-1).set(1,result.get(size-1).get(1)+time);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(curVal);
                list.add(time);
                result.add(list);
            }

            if(encoded1[i][1]==time&&encoded2[j][1]==time) {
                i++;
                j++;
                continue;
            }
            if(encoded1[i][1]==time){
                i++;
                encoded2[j][1]-=time;
            }else{
                j++;
                encoded1[i][1]-=time;
            }
        }
        return result;
    }
}
