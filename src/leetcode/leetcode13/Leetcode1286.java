package leetcode.leetcode13;

public class Leetcode1286 {

    class CombinationIterator {

        char[] c;
        int[] num;
        boolean hasNext=true;
        public CombinationIterator(String characters, int combinationLength) {
            this.c=characters.toCharArray();
            this.num=new int[combinationLength];
            for(int i=0;i<combinationLength;i++)
                num[i]=i;
        }

        public String next() {
            StringBuilder sb=new StringBuilder();
            for(int n:num){
                sb.append(c[n]);
            }
            if(num[0]==c.length-num.length){
                hasNext=false;
                return sb.toString();
            }
            for(int j=num.length-1;j>=0;j--){
                if(num[j]<c.length-(num.length-j)){
                    num[j]++;
                    for(int k=j+1;k<num.length;k++){
                        num[k]=num[j]+k-j;
                    }
                    return sb.toString();
                }
            }
            return "";
        }

        public boolean hasNext() {
            return hasNext;
        }
    }


}
