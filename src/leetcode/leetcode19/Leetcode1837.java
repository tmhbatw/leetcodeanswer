package leetcode.leetcode19;

public class Leetcode1837 {

    public int sumBase(int n, int k) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            sb.append(n%k);
            n/=k;
        }
        int result=0;
        for(int i=0;i<sb.length();i++)
            result+=sb.charAt(i)-'0';
        return result;
    }
}
