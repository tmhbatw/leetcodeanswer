package leetcode.leetcode10;

public class Leetcode944 {

    public int minDeletionSize(String[] strs) {
        if(strs.length==0||strs[0].length()==0)
            return 0;
        int row=strs.length,col=strs[0].length();
        int result=0;
        for(int j=0;j<col;j++){
            for(int i=1;i<row;i++){
                if(strs[i].charAt(j)<strs[i-1].charAt(j)){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
