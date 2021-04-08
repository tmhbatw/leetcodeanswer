package leetcode.leetcode3;

import java.util.HashMap;
import java.util.Map;

public class Leetcode291 {
    /*Description
    * 给你一种规律pattern和一个字符串str，请你判断str是否遵循其相同的规律。
    * 这里我们指的是 完全遵循，例如 pattern里的每个字母和字符串str中每个 非空 单词之间，
    * 存在着 双射 的对应规律。双射 意味着映射双方一一对应，不会存在两个字符映射到同一个字符串，
    * 也不会存在一个字符分别映射到两个不同的字符串。
    * */

    Map<Character,String> map1;
    Map<String,Character> map2;
    boolean result=false;
    public boolean wordPatternMatch(String pattern, String s) {
        map1=new HashMap<>();//用来保存pattern到s的映射
        map2=new HashMap<>();//用来保存s到pattern的映射
        recursion(pattern,0,s,0);
        return result;
    }

    private void recursion(String pattern,int index1, String s,int index2){
        System.out.println(map1);
        System.out.println(map2);
        if(result)
            return ;
        if(pattern.length()==index1&&s.length()==index2){
            result=true;
            return;
        }
        if(pattern.length()==index1||s.length()==index2)
            return;
        char cur=pattern.charAt(index1);
        if(map1.containsKey(cur)){
            String val=map1.get(cur);
            if(map2.get(val)==cur&&s.indexOf(val,index2)==index2)
                recursion(pattern,index1+1,s,index2+val.length());
        }
        else{
            for(int i=index2+1;i<=s.length();i++){
                String curVal=s.substring(index2,i);
                if(!map2.containsKey(curVal)){
                    map1.put(cur,curVal);
                    map2.put(curVal,cur);
                    recursion(pattern,index1+1,s,i);
                    map1.remove(cur);
                    map2.remove(curVal);
                }
            }
        }
    }

    public static void main(String[] args){
        String pattern="abba";
        String s="dogcatcatdog";
        System.out.println(new Leetcode291().wordPatternMatch(pattern,s));
    }
}
