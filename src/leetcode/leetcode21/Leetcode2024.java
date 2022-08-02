package leetcode.leetcode21;

public class Leetcode2024 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        //全改T
        //全改F
        return Math.max(getRes(answerKey,k,'T'),getRes(answerKey,k,'F'));
    }

    private int getRes(String answerKey,int k,int cur){
        int end=0;
        int result=0;
        for(int i=0;i<answerKey.length();i++){
            while(end<answerKey.length()&&(answerKey.charAt(end)==cur||k>0)){
                if(answerKey.charAt(end)!=cur)
                    k--;
                end++;
            }
            result=Math.max(end-i,result);
            if(answerKey.charAt(i)!=cur)
                k++;
        }
        return result;
    }

}
