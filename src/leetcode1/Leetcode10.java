package leetcode1;

public class Leetcode10 {
    /*Description
    * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
    * '.' 匹配任意单个字符'*' 匹配零个或多个前面的那一个元素
    * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
    * */

    public boolean isMatch(String s, String p) {
        StringBuilder pp=new StringBuilder();
        int length=p.length();
        for(int i=0;i<length;i++){
            char cur=p.charAt(i);
            if(cur=='*'){
                while(i<length-1&&p.charAt(i+1)=='*')
                    i++;
            }
            pp.append(cur);
        }
        return recursion(s,pp.toString(),0,0);
    }
    private boolean recursion(String s,String p,int sIndex,int pIndex){
        if(sIndex==s.length()&&p.length()==pIndex)
            return true;
        if(sIndex>s.length()||pIndex>=p.length())
            return false;
        char curS=sIndex>=s.length()?'1':s.charAt(sIndex),curP=p.charAt(pIndex);
        if((curS==curP||curP=='.')&&(recursion(s, p, sIndex + 1, pIndex + 1))) {
            return true;
        }
        if(pIndex<p.length()-1&&p.charAt(pIndex+1)=='*'&&recursion(s,p,sIndex,pIndex+2))
            return true;
        if(curP=='*'){
            char preP=p.charAt(pIndex-1);
            if(preP=='.'){
                for(int k=sIndex;k<=s.length();k++){
                    if(recursion(s,p,k,pIndex+1))
                        return true;
                }
            }
            else{
                if(recursion(s,p,sIndex,pIndex+1))
                    return true;
                while(preP==curS){
                    if(recursion(s,p,++sIndex,pIndex+1))
                        return true;
                    if(sIndex>=s.length())
                        break;
                    curS=s.charAt(sIndex);
                }
            }
        }
        return false;
    }
}
