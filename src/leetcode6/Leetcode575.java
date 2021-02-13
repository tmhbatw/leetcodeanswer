package leetcode6;

import java.util.Arrays;

public class Leetcode575 {
    /*Description
    * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
    * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
    * */

    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int typeNumber=0;
        int length=candyType.length;
        for(int i=0;i<length;i++){
            typeNumber++;
            while(i<length-1&&candyType[i+1]==candyType[i])
                i++;
        }
        return Math.min(length/2,typeNumber);
    }
}
