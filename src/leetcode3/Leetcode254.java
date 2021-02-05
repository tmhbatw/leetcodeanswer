package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class Leetcode254 {
    /*Description
    * 整数可以被看作是其因子的乘积。
    * */


    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                List<List<Integer>> list=getFactors(n/i,i);
                for(List<Integer> cur:list){
                    cur.add(0,i);
                    result.add(cur);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> getFactors(int n,int start){
        List<List<Integer>> result=new ArrayList<>();
        for(int i=start;i<=Math.sqrt(n);i++){
            if(n%i==0){
                List<List<Integer>> list=getFactors(n/i,i);
                for(List<Integer> cur:list) {
                    cur.add(0,i);
                    result.add(cur);
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        list.add(n);
        result.add(list);
        return result;
    }

    public static void main(String[] args){
        List<List<Integer>> result=new Leetcode254().getFactors(12);
        for(List<Integer> cur:result){
            System.out.println(cur);
        }
    }

}
