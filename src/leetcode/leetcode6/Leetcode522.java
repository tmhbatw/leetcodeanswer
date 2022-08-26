package leetcode.leetcode6;

public class Leetcode522 {

    public int findLUSlength(String[] strs) {
        int length=-1;
        for(int i=0;i<strs.length;i++){
            boolean flag=true;
            for(int j=0;j<strs.length;j++){
                if(i==j)
                    continue;
                if(!match(strs[i],strs[j])) {
                    flag=false;
                    break;
                }

            }
            if(flag)
                length=Math.max(length,strs[i].length());

        }
        return length;
    }

    private boolean match(String s1,String s2){
        int i=0;
        for(int j=0;j<s2.length();j++){
            if(s2.charAt(j)==s1.charAt(i)){
                i++;
            }
            if(i==s1.length())
                return false;
        }
        return true;
    }

}
