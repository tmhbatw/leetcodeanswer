package leetcode.leetcode23;

public class Leetcode2275 {

    public int largestCombination(int[] candidates) {
        int[] num=new int[32];
        for(int n:candidates){
            int index= 0;
            while(n>0){
                if(n%2==1)
                    num[index]++;
                n/=2;
                index++;
            }
        }

        int result = 0;
        for(int n:num)
            result =Math.max(n,result);

        return result;
    }

}
