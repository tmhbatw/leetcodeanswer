package leetcode7;

public class Leetcode693 {
    /*Description
    * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
    * */

    public boolean hasAlternatingBits(int n) {
        String s=Integer.toBinaryString(n);
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==s.charAt(i+1))
                return false;
        }
        return true;
    }
}
