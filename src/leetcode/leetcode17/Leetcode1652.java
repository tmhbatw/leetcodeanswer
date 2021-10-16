package leetcode.leetcode17;

public class Leetcode1652 {
    public int[] decrypt(int[] code, int k) {
        int[] res=new int[code.length];
        int length=code.length;
        for(int i=0;i<res.length;i++){
            int sum=0;
            if(k<0){
                for(int add=-1;add>=k;add--){
                    int index=(i+add+length)%length;
                    sum+=code[index];
                }
            }else{
                for(int add=1;add<=k;add++){
                    int index=(i+add)%length;
                    sum+=code[index];
                }
            }
            res[i]=sum;
        }
        return res;
    }
}
