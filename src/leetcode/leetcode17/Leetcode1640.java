package leetcode.leetcode17;

public class Leetcode1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int length=arr.length;
        for(int[] piece:pieces){
            length-=piece.length;
        }
        if(length!=0)
            return false;
        for(int i=0;i<arr.length;i++){
            boolean flag=true;
            for(int j=0;j<pieces.length&&flag;j++){
                if(arr[i]==pieces[j][0]){
                    if(!isSame(arr,pieces[j],i))
                        return false;
                    flag=false;
                    i+=pieces[j].length-1;
                }
            }
            if(flag)
                return false;
        }
        return true;
    }

    private boolean isSame(int[] arr,int[] piece,int i){
        for(int j=0;j<piece.length;j++){
            if(arr[i+j]!=piece[j])
                return false;
        }
        return true;
    }
}
