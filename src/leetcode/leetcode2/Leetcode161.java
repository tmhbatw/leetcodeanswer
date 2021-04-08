package leetcode.leetcode2;

public class Leetcode161 {
    /*Description
    * 给定两个字符串s 和 t，判断他们的编辑距离是否为 1。
    * 注意：
    * 满足编辑距离等于 1 有三种可能的情形：
    * 往 s中插入一个字符得到 t
    * 从 s中删除一个字符得到 t
    * 在 s中替换一个字符得到 t
    * */
    public boolean isOneEditDistance(String s, String t) {
        int sLength=s.length(),tLength=t.length();
        if(sLength==0&&tLength==0)
            return false;
        if(sLength==0&&tLength==1||sLength==1&&tLength==0)
            return true;
        if(sLength-tLength==1)
            return judge1(s,t);
        if(tLength-sLength==1)
            return judge1(t,s);
        return judge2(s,t);
    }

    private boolean judge2(String s,String t){
        if(s.length()!=t.length())
            return false;
        boolean diff=false;
        for(int i=0;i<s.length();i++){
            boolean same=s.charAt(i)==t.charAt(i);
            if(!same&&diff)
                return false;
            else if(!same)
                diff=true;
        }
        return diff;
    }

    private boolean judge1(String s,String t){
        int index=0;
        for(int i=0;i<t.length();i++){
            boolean same=s.charAt(index)==t.charAt(i);
            if(!same&&index-i==1)
                return false;
            else if(!same){
                i--;
            }
            index++;
        }
        return true;
    }
}
