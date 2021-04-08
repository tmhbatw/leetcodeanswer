package leetcode.leetcode1;

public class Leetcode76 {
    /*Description
    * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
    * */

    public String minWindow(String s, String t) {
        int[] num=new int[128];
        for(int i=0;i<t.length();i++)
            num[t.charAt(i)]++;
        int curMaxLength=Integer.MAX_VALUE;
        int result=-1;
        int[] numS=new int[128];
        int start=0;
        for(int i=0;i<s.length();i++){
            numS[s.charAt(i)]++;
            System.out.println("hello"+i+" "+start);
            if(isMatch(num,numS)){
                while(true){
                    numS[s.charAt(start++)]--;
                    if(!isMatch(num,numS)){
                        System.out.println(start+" "+i);
                        if(i-start+2<curMaxLength){
                            curMaxLength=i-start+2;
                            result=start-1;
                        }
                        break;
                    }
                }
            }
        }
        return result==-1?"":s.substring(result,result+curMaxLength);
    }

    private boolean isMatch(int[] num,int[] numS){
        for(int i=0;i<128;i++){
            if(num[i]>numS[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        String cur1="cabeca";
        String cur2="cae";
        System.out.println(new Leetcode76().minWindow(cur1,cur2));
    }
}
