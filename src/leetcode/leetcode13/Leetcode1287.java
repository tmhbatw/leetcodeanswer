package leetcode.leetcode13;

public class Leetcode1287 {

    public int findSpecialInteger(int[] arr) {
        int time=arr.length/4;
        int length=arr.length;
        for(int i=0;i<length;i++){
            int start=i;
            while(i<length-1&&arr[i+1]==arr[i])
                i++;
            if(i-start+1>time)
                return arr[i];
        }
        return arr[0];
    }
}
