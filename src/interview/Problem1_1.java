package interview;

public class Problem1_1 {
    /*Description
    * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
    * */
    public boolean isUnique(String astr) {
        boolean[] reached=new boolean[128];
        for(int i=0;i<astr.length();i++){
            if(reached[astr.charAt(i)])
                return false;
            reached[astr.charAt(i)]=true;
        }
        return true;
    }
}
