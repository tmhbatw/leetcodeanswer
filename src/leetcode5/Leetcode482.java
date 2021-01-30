package leetcode5;

public class Leetcode482 {
    /*Description
    * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
    * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，
    * 第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，
    * 并且将所有的小写字母转换为大写字母。给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
    * */

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)!='-')
                sb.append(S.charAt(i));
        }
        if(sb.length()==0)
            return "";
        int length=sb.length();
        int firstTime=length%K;
        firstTime=firstTime==0?K:firstTime;
        StringBuilder result=new StringBuilder();
        for(int i=0;i<firstTime;i++) {
            char cur=sb.charAt(i);
            if(cur<='z'&&cur>='a')
                cur=(char)(cur-'a'+'A');
            result.append(cur);
        }
        for(int i=firstTime;i<length;i+=K){
            result.append('-');
            for(int j=0;j<K;j++){
                char cur=sb.charAt(i+j);
                if(cur<='z'&&cur>='a')
                    cur=(char)(cur-'a'+'A');
                result.append(cur);
            }
        }
        return result.toString();
    }
}
