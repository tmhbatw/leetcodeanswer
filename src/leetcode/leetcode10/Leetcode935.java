package leetcode.leetcode10;

import java.util.Arrays;

public class Leetcode935 {

//    16,18
//    27,29
//    34,38
//    43,49
//    61,67
//    72,76
//    81,83
//    92,94
    static int[][] from=new int[][]{{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
    public int knightDialer(int n) {
        int mod=1000000007;
        int[] result=new int[10];
        Arrays.fill(result,1);

        for(int i=1;i<n;i++){
            int[] nextRes=new int[10];
            for(int j=0;j<10;j++){
                if(j==5)
                    continue;

                for(int k:from[j])
                    nextRes[j]=(nextRes[j]+result[k])%mod;
            }

            result=nextRes;
        }

        int res=0;
        for(int num:result)
            res=(res+num)%mod;
        return res;
    }

    public static void main(String[] args){
        for(int i=0;i<10;i++){
            for(int next:from[i]){
                System.out.print(i+""+next+" ");
            }
            System.out.println();
        }
    }
}
