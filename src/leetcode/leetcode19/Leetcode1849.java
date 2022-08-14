package leetcode.leetcode19;

public class Leetcode1849 {

    boolean result;
    public boolean splitString(String s) {
        dfs(0,s,-1);
        return result;
    }

    private  void dfs(int i,String s,long pre){
        if(result)
            return;
        if(i==s.length()){
            result=true;
            return;
        }

        if(i==0){
            for(int j=1;j<s.length();j++){
                try {
                    long cur = Long.parseLong(s.substring(0, j));
                    dfs(j,s,cur);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            for(int j=i+1;j<=s.length();j++){
                long cur = Long.parseLong(s.substring(i,j));
                if(cur==pre-1)
                    dfs(j,s,cur);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(Double.MAX_VALUE);
    }

}
