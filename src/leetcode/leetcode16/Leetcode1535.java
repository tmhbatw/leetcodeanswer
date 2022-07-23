package leetcode.leetcode16;

public class Leetcode1535 {

    public int getWinner(int[] arr, int k) {
        int max = 0;
        for(int i=0;i<Math.min(arr.length,k+1);i++)
            max=Math.max(max,arr[i]);

        for(int i=0;i<arr.length;i++){
            if(arr[i]>=max)
                return arr[i];
            int next=i+k;
            if(next<arr.length)
                max=Math.max(arr[next],max);

        }

        return -1;
    }
}
