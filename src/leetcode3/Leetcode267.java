package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode267 {
    /*Description
    * 给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
    * 如不能形成任何回文排列时，则返回一个空列表
    * */

    public List<String> generatePalindromes(String s) {
        List<String> result=new ArrayList<>();
        int[] time=new int[128];
        for(int i=0;i<s.length();i++)
            time[s.charAt(i)]++;
        int mid=-1;
        for(int i=0;i<128;i++){
            if(time[i]%2==1){
                if(mid!=-1)
                    return result;
                mid=i;
                time[i]--;
            }
        }
        System.out.println(Arrays.toString(time));
        List<String> list=generatePalindromes(time);
        for(String cur:list){
            String curr=cur+(mid==-1?"":(char)mid)+new StringBuilder(cur).reverse().toString();
            result.add(curr);
        }
        return result;
    }

    private List<String> generatePalindromes(int[] time){
        List<String> result=new ArrayList<>();
        for(int i=0;i<128;i++){
            if(time[i]>0){
                time[i]-=2;
                List<String> list=generatePalindromes(time);
                char c=(char)i;
                for(String cur:list)
                    result.add(c+cur);
                time[i]+=2;
            }
        }
        if(result.size()==0)
            result.add("");
        for(String cur:result)
            System.out.print(cur+" ");
        return result;
    }

    public static void main(String[] args){
        new Leetcode267().generatePalindromes("aabb");
    }

}
