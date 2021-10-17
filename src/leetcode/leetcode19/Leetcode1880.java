package leetcode.leetcode19;

public class Leetcode1880 {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        String first=getString(firstWord);
        String second=getString(secondWord);
        StringBuilder sum=new StringBuilder();
        int count=0;
        for(int j=0;j<Math.max(first.length(),second.length());j++){
            int cur=count;
            if(j<first.length())
                cur+=first.charAt(first.length()-1-j)-'0';
            if(j<second.length())
                cur+=second.charAt(second.length()-1-j)-'0';
            sum.append(cur%10);
            count=cur/10;
        }
        if(count!=0)
            sum.append(count);
        return Integer.parseInt(sum.reverse().toString())==(Integer.parseInt(getString(targetWord)));

    }

    private String getString(String cur){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<cur.length();i++){
            sb.append(cur.charAt(i)-'a');
        }
        return sb.toString();
    }
}
