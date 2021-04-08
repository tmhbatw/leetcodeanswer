package leetcode.leetcode5;

public class Leetcode492 {
    /*Description
    * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，
    * 你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
    * */

    public int[] constructRectangle(int area) {
        int[] result=new int[]{area,1};
        for(int i=2;i<=Math.sqrt(area);i++){
            if(area%i==0){
                result[1]=i;
            }
        }
        result[0]=area/result[1];
        return result;
    }
}
