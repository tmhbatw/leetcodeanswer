package leetcode2;

import java.util.List;

public class Leetcode120 {
    /*Description
    *给定一个三角形 triangle ，找出自顶向下的最小路径和。
    * 每一步只能移动到下一行中相邻的结点上。
    * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
    * */


    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null)
            return 0;
        int n=triangle.size();
        if(n==0)
            return 0;
        if(n==1)
            return triangle.get(0).get(0);
        int result=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            List<Integer> cur=triangle.get(i-1);
            List<Integer> curr=triangle.get(i);
            for(int j=0;j<=i;j++){
                int cur1=j>0?cur.get(j-1):Integer.MAX_VALUE;
                int cur2=j<i?cur.get(j):Integer.MAX_VALUE;
                curr.set(j,curr.get(j)+Math.min(cur1,cur2));
            }
            if(i==n-1){
                for(int j=0;j<n;j++){
                    result=Math.min(result,curr.get(j));
                }
            }
        }
        return result;
    }

}
