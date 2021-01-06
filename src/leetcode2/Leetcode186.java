package leetcode2;

public class Leetcode186 {
    /*Description
    * 给定一个字符串，逐个翻转字符串中的每个单词。
    * */

    public void reverseWords(char[] s) {
        int sLength=s.length;
        for(int i=0;i<sLength;i++){
            int left=i;
            while(i<sLength&&s[i]!=' '){
                i++;
            }
            int right=i==sLength-1?i:i-1;
            while(left<right){
                char temp=s[left];
                s[left]=s[right];
                s[right]=temp;
                left++;
                right--;
            }
        }
        for(int i=0;i<sLength/2;i++){
            char temp=s[i];
            s[i]=s[sLength-1-i];
            s[sLength-1-i]=temp;
        }
    }
}
