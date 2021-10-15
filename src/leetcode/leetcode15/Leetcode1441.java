package leetcode.leetcode15;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1441 {

    public List<String> buildArray(int[] target, int n) {
        int index=0;
        List<String> result=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(index==target.length)
                return result;
            if(target[index]>i){
                result.add("Push");
                result.add("Pop");
            }else{
                result.add("Push");
                index++;
            }
        }
        return result;
    }
}
