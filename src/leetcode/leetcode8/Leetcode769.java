package leetcode.leetcode8;

public class Leetcode769 {

    public int maxChunksToSorted(int[] arr) {
        int result=0;
        int max=0;

        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            if(max==i)
                result++;
        }

        return result;
    }
}
