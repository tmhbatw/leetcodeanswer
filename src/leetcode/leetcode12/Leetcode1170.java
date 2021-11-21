package leetcode.leetcode12;

public class Leetcode1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int[] res=new int[12];
        for(String w:words){
            res[getRes(w)]++;
        }

        for(int i=9;i>=0;i--){
            res[i]+=res[i+1];
        }

        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int num=getRes(queries[i]);
            result[i]=res[num+1];
        }

        return result;
    }

    private int getRes(String w){
        int[] num=new int[26];
        for(char c:w.toCharArray())
            num[c-'a']++;

        for(int n:num){
            if(n>0)
                return n;
        }

        return 0;
    }
}
