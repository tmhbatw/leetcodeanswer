package leetcode.leetcode24;

public class Leetcode2310 {

    public int minimumNumbers(int num, int k) {
        if(num==0)
            return 0;
        if(k==0)
            return num%10==0?1:-1;

       for(int j =1;j<=10;j++){
           if(num>=j*k&&(num -j*k)%10==0)
               return j;
       }

       return -1;
    }



    public static void main(String[] args){
        System.out.println(new Leetcode2310().minimumNumbers(20,1));
    }
}
