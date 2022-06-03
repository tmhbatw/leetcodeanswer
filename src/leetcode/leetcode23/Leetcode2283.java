package leetcode.leetcode23;

public class Leetcode2283 {

    public boolean digitCount(String num) {
        int[] n = new int[10];
        for(int i=0;i<num.length();i++){
            int time = num.charAt(i)-'0';
            n[i] += time;
            n[time] --;
        }

        for(int cur:n){
            if(cur!=0)
                return false;
        }

        return true;
    }
}
