package leetcode.leetcode16;

public class Leetcode1545 {


    public char findKthBit(int n, int k) {
        if(n==1)
            return '0';
        int num=(1<<n)-1;
        int mid=num/2+1;

        if(k==mid)
            return '1';

        if(k<mid)
            return findKthBit(n-1,k);

        return reverse(findKthBit(n-1,num+1-k));
    }

    private char reverse(char c){
        return c=='1'?'0':'1';
    }


}
