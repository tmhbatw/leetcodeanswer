package leetcode.leetcode19;

public class Leetcode1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1=sentence1.split(" ");
        String[] s2=sentence2.split(" ");
        int l1=s1.length,l2=s2.length;

        if(l1==l2)
            return sentence1.equals(sentence2);
        return s1.length<s2.length?match(s2,s1):match(s1,s2);
    }

    private boolean match(String[] s1,String[] s2){
        int i=0;
        for(;i<s2.length;i++){
            if(!s1[i].equals(s2[i]))
               break;
        }
        for(int j=s2.length-1;j>=i;j--){
            if(!s1[s1.length-(s2.length-j)].equals(s2[j]))
                return false;
        }

        return true;
    }


}
