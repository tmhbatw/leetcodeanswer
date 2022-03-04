package leetcode.leetcode16;

public class Leetcode1541 {

    public int minInsertions(String s) {
        int result=0;

        int preLeft=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                preLeft++;
            else{
                if(i==s.length()-1||s.charAt(i+1)!=')'){
                    result++;
                }else{
                    i++;
                }
                if(preLeft==0)
                    result++;
                else
                    preLeft--;
            }
        }

        return result+preLeft*2;
    }
}
