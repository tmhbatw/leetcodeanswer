package leetcode.leetcode23;

public class Leetcode2241 {

    class ATM {

        long[] bankCount=new long[5];
        int[] count = new int[]{20,50,100,200,500};
        public ATM() {

        }

        public void deposit(int[] banknotesCount) {
            for(int i=0;i<banknotesCount.length;i++)
                bankCount[i]+=banknotesCount[i];
        }

        public int[] withdraw(int amount) {
            long[] newCount = new long[5];
            for(int i=4;i>=0;i--){
                newCount[i] = Math.min(bankCount[i],amount/count[i]);
                amount -= newCount[i]*count[i];
            }

            if(amount!=0)
                return new int[]{-1};
            for(int i=0;i<5;i++)
                bankCount[i]-=newCount[i];

            int[] result=new int[5];
            for(int i=0;i<result.length;i++){
                result[i]=(int)newCount[i];
            }
            return result;
        }
    }
}
