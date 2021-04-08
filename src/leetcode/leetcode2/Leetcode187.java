package leetcode.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode187 {
    /*Description
    * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。
    * 在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
    * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
    * */

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list=new ArrayList<>();
        if(s==null||s.length()<=10)
            return list;
        int number=0;
        int add=1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<9;i++){
            int cur=getValue(s.charAt(i));
            number+=add*cur;
            add*=4;
        }
        for(int i=9;i<s.length();i++){
            number+=add*getValue(s.charAt(i));
            map.put(number,map.getOrDefault(number,0)+1);
            number/=4;
        }
        for(Map.Entry entry:map.entrySet()){
            if((int)entry.getValue()>1)
                list.add(getRes((int)entry.getKey()));
        }
        return list;
    }

    private String getRes(int cur){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
            char curr=getChar(cur%4);
            sb.append(curr);
            cur/=4;
        }
        return sb.toString();
    }


    private int getValue(char cur){
        switch (cur){
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            default:
                return 3;
        }
    }

    private char getChar(int cur){
        switch (cur){
            case 0:
                return 'A';
            case 1:
                return 'C';
            case 2:
                return 'G';
            default:
                return 'T';
        }
    }


    public static void main(String[] args){
        new Leetcode187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

}
