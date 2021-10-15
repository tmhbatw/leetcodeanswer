package leetcode.leetcode13;

public class Leetcode1221 {

    public int balancedStringSplit(String s) {
        int count=0;
        int length=s.length();
        for(int i=0;i<length;i++){
            int curCount=s.charAt(i)=='R'?1:-1;
            while(curCount!=0){
                char next=s.charAt(++i);
                if(next=='L')
                    curCount--;
                else
                    curCount++;
            }
            count++;
        }
        return count;
    }
}
