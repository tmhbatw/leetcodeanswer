package leetcode.leetcode14;

public class Leetcode1374 {
    public String generateTheString(int n) {
        StringBuilder sb=new StringBuilder();
        if(n%2==0){
            sb.append("b");
            n--;
        }
        for(int i=0;i<n;i++)
            sb.append("a");
        return sb.toString();
    }
}
