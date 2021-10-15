package leetcode.leetcode14;

public class Leetcode1323 {
    public int maximum69Number (int num) {
        char[] c=(num+"").toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='6'){
                c[i]='9';
                break;
            }
        }
        return Integer.parseInt(new String(c));
    }
}
