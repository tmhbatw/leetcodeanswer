package forOffer2;

public class ForOffer103 {

    public int coinChange(int[] coins, int amount) {
        int[] reached=new int[amount+1];
        reached[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                if(reached[i-coin]>0){
                    if(reached[i]==0)
                        reached[i]=reached[i-coin]+1;
                    else
                        reached[i]=Math.min(reached[i],reached[i-coin]+1);
                }
            }
        }
        return reached[amount]-1;
    }
}
