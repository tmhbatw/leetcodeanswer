package leetcode.leetcode15;

public class Leetcode1442 {

    public int countTriplets(int[] arr) {
        int[] num=new int[arr.length+1];

        for(int i=0;i<arr.length;i++)
            num[i+1]=num[i]^arr[i];

        int result=0;
        for(int i=0;i<arr.length-2;i++) {
            for(int j=i+1;j<arr.length-1;j++){
                for(int k=j+1;k<arr.length;k++){
                    if((num[j+1]^num[i])==(num[k+1]^num[j]))
                        result++;
                }
            }
        }
        return result;
    }
}
