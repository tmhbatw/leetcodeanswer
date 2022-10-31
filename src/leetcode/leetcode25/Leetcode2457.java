package leetcode.leetcode25;

public class Leetcode2457 {

    public long makeIntegerBeautiful(long n, int target) {
        int count=getCount(n);

        if(count<=target)
            return 0;
        long base=1;
        long cur=n;
        while(cur>0){
            int left= (int) (cur%10);
            if(left>0){
                long add=base*10-left*base;
                n += add;
                return add+makeIntegerBeautiful(n,target);
            }
            cur/=10;
            base*=10;
        }
        return 0;
    }

    private int getCount(long n){
        int count =0;
        while(n>0){
            count+=n%10;
            n/=10;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println("Learn to be better!");
    }
}
