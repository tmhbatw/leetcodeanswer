package leetcode.leetcode24;

public class Leetcode2303 {

    public double calculateTax(int[][] brackets, int income) {
        double result = 0;

        int pre = 0;
        for(int[] cur:brackets){
            if(income<=cur[0]){
                result += 1.0*(income-pre)*cur[1]/100;
                break;
            }
            else{
                result += 1.0*(cur[0]-pre)*cur[1]/100;
                pre = cur[0];
            }
        }

        return result;
    }
}
