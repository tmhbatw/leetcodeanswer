package leetcode.leetcode13;

public class Leetcode1271 {
    public String toHexspeak(String num) {
        long n=Long.parseLong(num);
        StringBuilder sb=new StringBuilder();
        while(n>0){
            long last=n%16;
            if(last<10&&last!=1&&last!=0)
                return "ERROR";
            n/=16;
            if(last==1)
                sb.append('I');
            else if(last==0)
                sb.append('O');
            else
                sb.append((char)('A'+last-10));

        }
        return sb.reverse().toString();
    }

}
