package leetcode.leetcode12;

public class Leetcode1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res=new int[n+2];
        for(int[] book:bookings){
            res[book[0]]+=book[2];
            res[book[1]+1]-=book[2];
        }

        int[] result=new int[n];
        for(int i=0;i<result.length;i++){
            res[i+1]+=res[i];
            result[i]=res[i+1];
        }
        return result;
    }
}
