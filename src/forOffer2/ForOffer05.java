package forOffer2;

import java.util.Arrays;

public class ForOffer05 {

    public int maxProduct(String[] words) {
        int[] res=new int[words.length];
        for(int i=0;i<words.length;i++)
            res[i]=getRes(words[i]);
        int result=0;
        System.out.println(Arrays.toString(res));
        for(int i=0;i<res.length;i++){
            for(int j=i+1;j<res.length;j++){
                if((res[i]&res[j])==0)
                    result=Math.max(words[i].length()*words[j].length(),result);
            }
        }
        return result;
    }

    private int getRes(String cur){
        boolean[] reached=new boolean[26];
        for(int i=0;i<cur.length();i++)
            reached[cur.charAt(i)-'a']=true;
        int base=1;
        int res=0;
        for(int i=0;i<26;i++){
            if(reached[i])
                res+=base;
            base*=2;
        }
        return res;
    }
}
