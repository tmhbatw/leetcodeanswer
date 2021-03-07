package competition1;

public class Problem3 {

    public int beautySum(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            int[] num=new int[26];
            for(int j=i;j<s.length();j++){
                num[s.charAt(j)-'a']++;
                res+=getVal(num);
            }
        }
        return res;
    }

    private int getVal(int[] num){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int cur:num){
            if(cur!=0){
                max=Integer.max(cur,max);
                min=Integer.min(cur,min);
            }
        }
        return max-min;
    }
}
