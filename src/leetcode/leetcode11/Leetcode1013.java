package leetcode.leetcode11;

public class Leetcode1013 {

    public boolean canThreePartsEqualSum(int[] arr) {
        int[] sum=new int[arr.length+1];
        for(int i=0;i<arr.length;i++)
            sum[i+1]=arr[i]+sum[i];
        int s=sum[arr.length];
        if(s%3!=0)
            return false;
        int count=0;
        int target=s/3;
        for(int i=1;i<=arr.length-1;i++){
            if(target==sum[i]){
                target+=s/3;
                count++;
            }
            if(count==2)
                return true;
        }
        return false;
    }
}
