package leetcode.leetcode20;

public class Leetcode1945 {

    public int getLucky(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)-'a'+1);
        }
        int cur=0;
        for(int i=0;i<sb.length();i++){
            cur+=sb.charAt(i)-'0';
        }
        for(int j=1;j<k;j++){
            int curRes=0;
            while(cur>0){
                curRes+=cur%10;
                cur/=10;
            }
            cur=curRes;
        }
        return cur;
    }
}
