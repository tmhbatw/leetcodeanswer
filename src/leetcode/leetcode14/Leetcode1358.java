package leetcode.leetcode14;

public class Leetcode1358 {

    public int numberOfSubstrings(String s) {
        int[] count=new int[3];
        int j=0;
        int result=0;
        for(int i=0;i<s.length();i++){
            while(j<s.length()&&(count[0]==0||count[1]==0||count[2]==0)){
                char n=s.charAt(j++);
                count[n-'a']++;
            }
            if(count[0]==0||count[1]==0||count[2]==0)
                break;
            result+=s.length()+1-j;
            count[s.charAt(i)-'a']--;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println("hello world!");
    }
}
