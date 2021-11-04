package leetcode.leetcode7;

public class Leetcode647 {

    public int countSubstrings(String s) {

        int length=s.length();
        boolean[][] res=new boolean[length][length];

        int result=s.length();
        for(int i=0;i<length-1;i++){
            res[i][i]=true;
            if(s.charAt(i)==s.charAt(i+1)) {
                res[i][i + 1] = true;
                result++;
            }
        }
        res[length-1][length-1]=true;
        for(int l=2;l<length;l++){
            for(int i=0;i<length-l+1;i++){
                if(s.charAt(i)==s.charAt(i+l)&&res[i+1][i+l-1]){
                    result++;
                    res[i][i+l]=true;
                }
            }
        }
        return result;
    }
}
