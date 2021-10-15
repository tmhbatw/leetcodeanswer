package leetcode.leetcode16;

public class Leetcode1550 {

    public boolean threeConsecutiveOdds(int[] arr) {
        int length=arr.length;
        for(int i=0;i<length-2;i++){
            if(arr[i]%2==0&&arr[i+1]%2==0&&arr[i+2]%2==0)
                return true;
        }
        return false;
    }
}
