package leetcode.leetcode5;

public class Leetcode443 {

    public int compress(char[] chars) {
        int result=0;
        for(int i=0;i<chars.length;i++){
            char cur=chars[i];
            int start=i;
            while(i<chars.length-1&&chars[i+1]==cur)
                i++;
            int count=i-start+1;
            if(count>1){
                String s=(count+"");
                chars[result]=cur;
                for(int j=result+1;j<result+1+s.length();j++)
                    chars[j]=s.charAt(j-result-1);
                result+=s.length()+1;
            }
            else{
                chars[result]=cur;
                result++;
            }
        }
        return result;
    }
}
