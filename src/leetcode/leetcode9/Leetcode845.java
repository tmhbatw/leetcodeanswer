package leetcode.leetcode9;

public class Leetcode845 {

    public int longestMountain(int[] arr) {
        int type=0;
        int pre=0;
        int result=0;

        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                type=0;
                pre=0;
            }
            if(arr[i]>arr[i-1]){
                if(type>=0){
                    pre++;
                }else{
                    pre=1;
                }
                type=1;
            }
            if(arr[i]<arr[i-1]){
                if(type==0)
                    continue;
                else{
                    pre++;
                }
                type=-1;
            }
            if(type==-1){
                result=Math.max(result,pre);
            }
        }
        return result==0?0:result+1;
    }
}
