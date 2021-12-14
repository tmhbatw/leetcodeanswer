package leetcode.leetcode7;

public class Leetcode625 {

    public int smallestFactorization(int num) {
        if(num==1)
            return 1;
        int[] n=new int[10];
        int count=0;
        for(int i=9;i>=2;i--){
            if(num%i==0){
                n[i]++;
                num/=i;
                count++;
            }
        }
        if(num>1||count>10)
            return 0;

        int res=0;
        for(int i=2;i<=9;i++){
            for(int j=0;j<n[i];j++)
                res=res*10+i;
        }
        return res;
    }
}
