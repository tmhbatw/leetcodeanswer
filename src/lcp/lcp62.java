package lcp;

public class lcp62 {

    public int transportationHub(int[][] path) {
        int[] num1=new int[1001];
        int[] num2=new int[1001];

        int max=0;
        for(int[] p:path){
            num1[p[0]]++;
            num2[p[1]]++;
            max=Math.max(max,p[0]);
            max=Math.max(max,p[1]);
        }

        for(int i=0;i<=max;i++){
            if(num1[i]==0&&num2[i]==max)
                return i;
        }
        return -1;
    }


}
