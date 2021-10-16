package leetcode.leetcode18;

public class Leetcode1796 {
    public int secondHighest(String s) {
        int first=-1;
        int second=-1;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur<='9'&&cur>='0'){
                int curr=cur-'0';
                if(curr>first){
                    second=first;
                    first=curr;
                }else if(curr<first&&curr>second){
                    second=curr;
                }
            }
        }
        return second;
    }
}
