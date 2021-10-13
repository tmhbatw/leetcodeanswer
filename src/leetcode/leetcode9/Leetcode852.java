package leetcode.leetcode9;

public class Leetcode852 {
    public int peakIndexInMountainArray(int[] arr) {
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>arr[i-1]&&arr[i]>arr[i+1])
                return i;
        }
        return -1;
    }
}
