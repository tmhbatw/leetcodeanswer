package leetcode.leetcode1;

import java.util.HashMap;
import java.util.Map;

public class Leetcode96 {
    /*Description
    * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
    * */

    public int numTrees(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        return recursion(1,n,map);
    }

    private int recursion(int start,int end,Map<Integer,Integer> map){
        if(map.containsKey(end-start))
            return map.get(end-start);
        if(start>=end)
            return 1;
        int result=0;
        for(int i=start;i<=end;i++){
            result+=recursion(start,i-1,map)*recursion(i+1,end,map);
        }
        map.put(end-start,result);
        return result;
    }
}
