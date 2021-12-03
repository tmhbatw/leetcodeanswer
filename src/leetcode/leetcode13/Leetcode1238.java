package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1238 {

    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result=getRes(n);
        int index=0;
        for(;index<result.size();index++){
            if(result.get(index)==start)
                break;
        }

        List<Integer> list=new ArrayList<>();
        for(int i=index;i<result.size();i++)
            list.add(result.get(i));
        for(int i=0;i<index;i++)
            list.add(result.get(i));
        return list;
    }

    private List<Integer> getRes(int n){
        List<Integer> result=new ArrayList<>();
        if(n==1){
            result.add(0);
            result.add(1);
            return result;
        }
        List<Integer> pre=getRes(n-1);
        result.addAll(pre);
        int add= (int) Math.pow(2,n-1);
        for(int j=pre.size()-1;j>=0;j--){
            result.add(pre.get(j)+add);
        }
        return result;
    }
}
