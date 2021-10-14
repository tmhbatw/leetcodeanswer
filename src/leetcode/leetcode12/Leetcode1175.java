package leetcode.leetcode12;

public class Leetcode1175 {
    int mod=1000000007;
    public int numPrimeArrangements(int n) {
        if(n<=2)
            return 1;
        int primeNumber=getPrimeNumber(n);
        int otherNumber=n-primeNumber;
        return (int) (getRes(primeNumber)*getRes(otherNumber)%mod);
    }

    private int getPrimeNumber(int n){
        int number=1;
        for(int i=3;i<=n;i+=2){
            boolean isPrime=true;
            for(int j=3;j<=Math.sqrt(i)&&isPrime;j+=2){
                if(i%j==0){
                    isPrime=false;
                }
            }
            if(isPrime)
                number++;
        }
        return number;
    }

    private long getRes(int n){
        long res=1;
        for(int i=1;i<=n;i++){
            res=(res*i)%mod;
        }
        return res;
    }
}
