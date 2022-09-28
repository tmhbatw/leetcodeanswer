package leetcode.leetcode10;

public class Leetcode955 {

    public int minDeletionSize(String[] strs) {
        int result=0;
        String[] str=new String[strs.length];
        for(int j=0;j<strs[0].length();j++){
            String[] newStr=str.clone();
            boolean add=true;
            for(int i=0;i<strs.length&&add;i++){
                newStr[i]+=strs[i].charAt(j);
                if(i>0&&newStr[i].compareTo(newStr[i-1])<0){
                    add=false;
                }
            }

            if(add)
                str=newStr;
            else result++;
        }

        return result;
    }


}
