package leetcode.leetcode17;

public class Leetcode1663 {

    public String getSmallestString(int n, int k) {
        StringBuilder sb=new StringBuilder();
        k-=n;

        while(n-->0){
            int remove=Math.min(25,k);
            char cur=(char)('a'+remove);

            sb.append(cur);
            k-=remove;
        }

        return sb.reverse().toString();
    }
}
