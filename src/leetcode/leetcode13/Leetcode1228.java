package leetcode.leetcode13;

public class Leetcode1228 {

    public int missingNumber(int[] arr) {
        int d1=arr[1]-arr[0];
        int d2=arr[arr.length-1]-arr[arr.length-2];

        int d=getDiff(d1,d2);
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]!=d)
                return arr[i-1]+d;
        }
        return -1;
    }
    private int getDiff(int d1,int d2){
        if(d1<0)
            return Math.max(d1,d2);
        return Math.min(d1,d2);
    }
}
