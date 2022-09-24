package leetcode.leetcode13;

public class Leetcode1234 {

    public int balancedString(String s) {
        int max=s.length()/4;
        int[] time=new int[26];

        int j=s.length()-1;
        for(;j>=0;j--){
            time[s.charAt(j)-'A']++;
            if(time[s.charAt(j)-'A']>max){
                time[s.charAt(j++)-'A']--;
                break;
            }
        }
        if(j==-1)
            return 0;
        int result = s.length()-j;
        for(int i=0;i<s.length();i++){

            int index=s.charAt(i)-'A';
            time[index]++;

            while(time[index]>max){
                if(j==s.length())
                    return s.length()-result;

                time[s.charAt(j++)-'A']--;
            }
            result=Math.max(result,i+1+s.length()-j);
        }
        return s.length()-result;
    }

}
