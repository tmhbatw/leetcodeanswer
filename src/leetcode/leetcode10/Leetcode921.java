package leetcode.leetcode10;

public class Leetcode921 {
    public int minAddToMakeValid(String s) {
        int result=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                count++;
            else{
                count--;
                if(count<0){
                    result++;
                    count++;
                }
            }
        }
        return result+count;
    }
}
