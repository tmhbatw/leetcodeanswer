package leetcode3;

public class Leetcode204 {
    /*Description
    * 统计所有小于非负整数 n 的质数的数量。
     * */

    public int countPrimes(int n) {
        if(n<=2)
            return 0;
        boolean[] prime=new boolean[n];
        int result=0;
        for(int i=2;i<n;i++){
            if(!prime[i]){
                result++;
                for(int j=i;(long)j*(long)i<n;j++){
                    prime[j*i]=true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int cur=5000000;
        System.out.println(cur*cur);
    }

    private boolean isPrime(int n){
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
