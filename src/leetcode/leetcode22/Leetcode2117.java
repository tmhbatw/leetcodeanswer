package leetcode.leetcode22;

public class Leetcode2117 {

    public String abbreviateProduct(int left, int right) {
        long result = 1;
        int zero=0;
        long pre = 1;
        long last= 1;

        long changeValue = 9999999999L;
        boolean flag = true;

        for(int i=left;i<=right;i++){
            if(flag){
                result*=i;

            }


        }

        return "";

    }
}
