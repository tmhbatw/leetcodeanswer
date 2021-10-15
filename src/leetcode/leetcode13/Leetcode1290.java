package leetcode.leetcode13;

public class Leetcode1290 {
    public int[] replaceElements(int[] arr) {
        int last=-1;
        for(int j=arr.length-1;j>=0;j--){
            int temp=arr[j];
            arr[j]=last;
            last=Math.max(temp,last);
        }
        return arr;
    }
}
