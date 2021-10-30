package leetcode.leetcode5;

public class Leetcode481 {

    public int magicalString(int n) {
        if(n<=3)
            return 1;
        StringBuilder sb=new StringBuilder();
        sb.append("122");
        int index=2;
        char cur='1';
        while(sb.length()<n){
            int time=sb.charAt(index++)-'0';
            while(time-->0){
                sb.append(cur);
            }
            cur=cur=='1'?'2':'1';
        }
        int result=0;
        for(int i=0;i<n;i++){
            if(sb.charAt(i)=='1')
                result++;
        }
        return result;
    }
}
