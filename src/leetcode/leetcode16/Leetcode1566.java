package leetcode.leetcode16;

public class Leetcode1566 {

    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i=0;i<=arr.length-m*k;i++){
            boolean flag=true;
            for(int j=1;j<k&&flag;j++){
                int i2=j*m+i;

                if(!isSame(arr,i,i2,m))
                    flag=false;
            }
            if(flag)
                return true;
        }
        return false;
    }

    private boolean isSame(int[] arr,int i1,int i2,int k){
        for(int i=0;i<k;i++){
            if(arr[i+i1]!=arr[i+i2])
                return false;
        }
        return true;
    }
}
