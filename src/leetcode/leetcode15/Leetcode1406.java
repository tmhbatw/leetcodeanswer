package leetcode.leetcode15;

public class Leetcode1406 {
    private final String AliceWin="Alice";
    private final String BobWin="Bob";
    private final String Tie="Tie";
    public String stoneGameIII(int[] stoneValue) {
        int length=stoneValue.length;
        if (length==1){
            return stoneValue[0]>0?AliceWin:(stoneValue[0]<0?BobWin:Tie);
        }
        if(length==2){
            if(stoneValue[0]<0&&-stoneValue[0]==Math.abs(stoneValue[1]))
                return Tie;
            if(stoneValue[0]<0&&-stoneValue[0]<Math.abs(stoneValue[1]))
                return BobWin;
            return AliceWin;
        }

        int[] sum=new int[length+1];
        for(int j=length-1;j>=0;j--)
            sum[j]=sum[j+1]+stoneValue[j];

        int[] max=new int[length+1];
        max[length-1]=stoneValue[length-1];
        max[length-2]=Math.max(0,max[length-1])+stoneValue[length-2];

        for(int j=length-3;j>=0;j--){
            max[j]=stoneValue[j]+sum[j+1]-max[j+1];//拿一堆
            max[j]=Math.max(max[j],stoneValue[j+1]+stoneValue[j]+sum[j+2]-max[j+2]);//拿两堆
            max[j]=Math.max(max[j],stoneValue[j]+stoneValue[j+1]+
                    stoneValue[j+2]+sum[j+3]-max[j+3]);//拿三堆
        }

        return max[0]*2-sum[0]>0?AliceWin:(max[0]*2-sum[0]==0?Tie:BobWin);
    }
}
