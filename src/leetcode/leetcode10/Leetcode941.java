package leetcode.leetcode10;

public class Leetcode941 {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3||arr[1]<=arr[0])
            return false;
        boolean statusAdd=true;
        for(int i=2;i<arr.length;i++){
            if(arr[i]==arr[i-1])
                return false;
            if(statusAdd){
                if(arr[i]<arr[i-1])
                    statusAdd=false;
            }else{
                if(arr[i]>arr[i-1])
                    return false;
            }
        }
        return !statusAdd;
    }

}
