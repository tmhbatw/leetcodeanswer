package leetcode.leetcode2;

public class Leetcode159 {
    /*Description
    * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
    * */

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char c1=' ',c2=' ';
        int count1=0,count2=0;
        int length=s.length();
        int result=0;
        int start=-1;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur==c1) {
                count1++;
            }else if(cur==c2){
                count2++;
            }else if(c1==' '){
                c1=cur;
                count1=1;
            }else if(c2==' '){
                c2=cur;
                count2=1;
            }else{
                while(count1!=0&&count2!=0){
                    char curr=s.charAt(++start);
                    if(curr==c1)
                        count1--;
                    else
                        count2--;
                }
                if(count1==0){
                    c1=cur;
                    count1=1;
                }else{
                    c2=cur;
                    count2=1;
                }
            }
            result=Math.max(result,i-start);
        }
        return result;
    }
}
