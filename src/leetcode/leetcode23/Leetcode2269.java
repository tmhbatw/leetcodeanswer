package leetcode.leetcode23;

public class Leetcode2269 {

    public int divisorSubstrings(int num, int k) {
        String n=num+"";
        int result = 0;
        for(int i=k;i<=n.length();i++){
            int cur = Integer.parseInt(n.substring(i-k,i));
            if(cur!=0&&num%cur==0)
                result++;
        }
        return result;
    }
}
