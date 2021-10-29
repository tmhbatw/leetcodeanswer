package leetcode.leetcode5;

public class Leetcode400 {

    public int findNthDigit(int n) {
        long cur=1;
        long base=9;
        while(n>0){
            if(n>base*cur){
                n-=base*cur;
                base*=10;
                cur++;
                continue;
            }
            base/=9;
            base+=n/cur-1;
            if(n%cur==0)
                return (int)(base%10);
            base+=1;
            return  (base+"").charAt((int)(n%cur)-1)-'0';
        }
        return -1;
    }
}
