package leetcode.leetcode22;

public class Leetcode2180 {

    public int countEven(int num) {
        int result=0;
        for(int i=2;i<=num;i++){
            int cur=i;
            int c=0;
            while(cur>0){
                c+=cur%10;
                cur/=10;
            }
            if(c%2==0)
                result++;
        }

        return result;
    }
}
