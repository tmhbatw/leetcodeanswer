package leetcode8;

import java.util.HashSet;
import java.util.Set;

public class Leetcode771 {
    /*Description
    *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
    *  S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
    * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

    * */

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            set.add(jewels.charAt(i));
        }
        int result=0;
        for(int i=0;i<stones.length();i++){
            if(set.contains(stones.charAt(i)))
            result++;
        }
        return result;
    }
}
