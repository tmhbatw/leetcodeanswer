package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode17 {
    /*Description
    * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    * */

    char[][] c=new char[9][];
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0)
            return Collections.emptyList();
        List<String> result=new ArrayList<>();
        String[] s=new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=0;i<9;i++){
            c[i]=s[i].toCharArray();
        }
        recursion(result,new StringBuilder(),0,digits);
        return result;
    }

    private void recursion(List<String> list,StringBuilder sb,int index,String digits){
        if(index==digits.length()){
            list.add(sb.toString());
            return;
        }
        int cur=digits.charAt(index)-'1';
        for(int i=0;i<c[cur].length;i++){
            StringBuilder curSb=new StringBuilder(sb);
            curSb.append(c[cur][i]);
            recursion(list,curSb,index+1,digits);
        }
    }

    public static void main(String[] args){
        List<String> result=new Leetcode17().letterCombinations("23");
        for(String cur:result)
            System.out.println(cur);
    }
}
