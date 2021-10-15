package leetcode.leetcode14;

public class Leetcode1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        for(int cur:arr1){
            boolean flag=true;
            for(int i=0;i<arr2.length&&flag;i++){
                if(Math.abs(cur-arr2[i])<=d)
                    flag=false;
            }
            if(flag)
                count++;
        }
        return count;
    }
}
