package forOffer;

public class forOffer11 {
    /*Description
    * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
    * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
    * */

    public int minArray(int[] numbers) {
        int min=Integer.MAX_VALUE;
        for(int cur:numbers)
            min=Integer.min(cur,min);
        return min;

    }
}
