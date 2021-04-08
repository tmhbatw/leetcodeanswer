package leetcode.leetcode5;

public class Leetcode476 {
    /*Description
    * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
    * */

    public int findComplement(int num) {
        String n=Integer.toBinaryString(num);
        int result=0;
        int count=1;
        for(int i=n.length()-1;i>=0;i--){
            char cur=n.charAt(i);
            if(cur=='0')
                result+=count;
            count*=2;
        }
        return result;
    }
}
