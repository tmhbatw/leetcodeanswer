package leetcode.leetcode19;

public class Leetcode1816 {

    public String truncateSentence(String s, int k) {
        String[] ss=s.split(" ");
        StringBuilder sb=new StringBuilder();
        sb.append(ss[0]);
        for(int i=1;i<k;i++)
            sb.append("").append(ss[i]);
        return sb.toString();
    }
}
