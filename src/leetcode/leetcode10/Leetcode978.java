package leetcode.leetcode10;

public class Leetcode978 {

    public int maxTurbulenceSize(int[] arr) {
        int type=0;
        int result=0;
        int pre=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                pre=0;
                type=0;
            }
            if(arr[i]>arr[i-1]){
                if(type<=0){
                    pre++;
                    type=1;
                }else{
                    pre=1;
                }
            }
            if(arr[i]<arr[i-1]){
                if(type>=0){
                    pre++;
                    type=-1;
                }else{
                    pre=1;
                }
            }
            result=Math.max(result,pre);
        }
        return result;
    }
}
