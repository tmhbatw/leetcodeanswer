package leetcode.leetcode9;

public class Leetcode866 {

    public int primePalindrome(int n) {
        int length=(n+"").length();
        boolean small=length%2==1;
        int start = n;
        for(int i=0;i<length/2;i++)
            start/=10;
        int max=1;
        for(int i=0;i<(length+1)/2;i++)
            max*=10;
        for(int i=start;i<max;i++){
            int cur = getRes(i,small);
            //System.out.println(cur+" "+n);
            if(cur>=n&&isPrime(cur))
                return cur;
        }
        max=1;
        for(int i=0;i<length;i++)
            max*=10;
        return primePalindrome(max);
    }

    private int getRes(int cur,boolean small){
        int left=cur;
        if(small)
            left/=10;
        while(left>0){
            cur=cur*10+left%10;
            left/=10;
        }
        return cur;
    }

    private boolean isPrime(int n){
        if(n==1)
            return false;
        if(n%2==0)
            return n==2;
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        new Leetcode866().primePalindrome(13);
    }
}
