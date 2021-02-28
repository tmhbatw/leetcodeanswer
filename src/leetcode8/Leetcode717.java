package leetcode8;

public class Leetcode717 {
    /*Description
    * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
    * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
    * */

        public boolean isOneBitCharacter(int[] bits) {
            for(int i=0;i<bits.length;i++){
                if(i==bits.length-1)
                    return true;
                if(bits[i]==1)
                    i++;
            }
            return false;
        }
}
