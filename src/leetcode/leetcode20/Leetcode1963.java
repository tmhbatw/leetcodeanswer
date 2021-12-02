package leetcode.leetcode20;

public class Leetcode1963 {

    public int minSwaps(String s) {
        int count=0;
        int res=0;

        for(char c:s.toCharArray()){
            if(c=='[')
                count--;
            else
                count++;
            res=Math.max(count,res);
        }

        return (res+1)/2;
    }
}
