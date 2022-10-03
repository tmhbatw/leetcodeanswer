package leetcode.leetcode25;

public class Leetcode2417 {

    public int closestFair(int n) {
        int length=(n+"").length();
        if(length%2==1){
            int cur=1;
            while(length-->0){
                cur*=10;
            }
            return getRes(cur);
        }
        int max=0;
        for(int i=0;i<length/2;i++){
            max=max*10+9;
        }
        for(int i=0;i<length/2;i++){
            max=max*10+8;
        }
        if(n>max){
            int cur=10;
            while(length-->0){
                cur*=10;
            }
            return getRes(cur);
        }
        return getRes(n);
    }

    private int getRes(int n){
        while(!match(n))
            n++;
        return n;
    }

    private boolean match(int n){
        int odd=0;
        int even=0;
        while(n>0){
            int left=n%10;
            if(left%2==0)
                odd++;
            else
                even++;
            n/=10;
        }
        return odd==even;
    }

    public static void main(String[] args){
        int t=99999999;
        System.out.println(new Leetcode2417().closestFair(t));
    }


}
