package lcp.competition1;

public class Problem2 {
    /*Description
    *
    * */

    private boolean fun1(int n){
        if(n==1)
            return true;
        while(n>1){
            if(n%3==0)
                n/=3;
            else
                return false;
        }
        return n==1;
    }
    boolean result=false;
    public boolean checkPowersOfThree(int n) {
        check(n,14);
        return result;
    }

    private void  check(int num,int start){
        if(num==0)
            result=true;
        if(result)
            return;
        for(int i=start;i>=0;i--){
            if(num>=Math.pow(3,i)){
                check((int) (num-Math.pow(3,i)),i-1);
            }
        }
    }


    public static void main(String[] args){
        System.out.println(new Problem2().checkPowersOfThree(10000000));
    }
}
