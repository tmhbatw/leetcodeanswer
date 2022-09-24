package leetcode.leetcode7;

public class Leetcode667 {

    public int[] constructArray(int n, int k) {
        int[] result=new int[n];
        int min=1,max=n;
        boolean flag=true;

        for(int i=0;i<k;i++){
            if(flag)
                result[i]=min++;
            else
                result[i]=max--;
            flag=!flag;
        }
        for(int i=k;i<result.length;i++){
            if(flag)
                result[i]=max--;
            else
                result[i]=min++;
        }
        return result;
    }


}
