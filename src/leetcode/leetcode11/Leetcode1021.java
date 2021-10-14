package leetcode.leetcode11;

public class Leetcode1021 {

    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int length=s.length();
        for(int i=0;i<length;i++){
            int count=1;
            int start=i;
            while(count!=0){
                i++;
                if(s.charAt(i)=='(')
                    count++;
                else
                    count--;
            }
            sb.append(s, start+1, i);
        }
        return sb.toString();
    }
}
