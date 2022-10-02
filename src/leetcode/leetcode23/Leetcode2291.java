package leetcode.leetcode23;

public class Leetcode2291
{

    public int maximumProfit(int[] present, int[] future, int budget) {
        int[] result=new int[budget+1];
        for(int i=0;i<present.length;i++){
            future[i]=Math.max(future[i]-present[i],0);
        }
        for(int i=0;i<present.length;i++){
            for(int j=budget;j>=present[i];j--){
                result[j]=Math.max(result[j-present[i]]+future[i],result[j]);
            }
        }

        return result[budget];
    }


}
