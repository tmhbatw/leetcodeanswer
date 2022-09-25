package lcp;

public class lcp61 {

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int result=0;
        int cur=0;
        for(int i=1;i<temperatureA.length;i++){
            if(temperatureA[i]==temperatureA[i-1]&&temperatureB[i]==temperatureB[i-1]
                ||(temperatureA[i]-temperatureA[i-1])*(temperatureB[i]-temperatureB[i-1])>0)
                cur++;
            else{
                result=Math.max(result,cur);
                cur=0;
            }
        }
        return Math.max(cur,result);

    }
}
