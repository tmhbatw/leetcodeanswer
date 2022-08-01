package leetcode.leetcode24;

public class Leetcode2358 {
    //n*(n+1)/2
    public int maximumGroups(int[] grades) {
        int length=grades.length;
        int l=1,r=100000;
        while(l<r){
            long mid=(l+r+1)/2;
            System.out.println(mid+" "+mid*(mid+1)/2);
            if(mid*(mid+1)/2<=length)
                l=(int)mid;
            else
                r=(int)mid-1;
        }
        return l;
    }
}
