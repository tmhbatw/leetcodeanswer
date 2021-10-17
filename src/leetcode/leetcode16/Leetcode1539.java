package leetcode.leetcode16;

public class Leetcode1539 {

    public int findKthPositive(int[] arr, int k) {
        int index=0;
        int i=0;
        while(k>0){
            while(index<arr.length&&i+1==arr[index]){
                i++;
                index++;
            }
            i++;
            k--;
        }
        return i;
    }
}
