package leetcode.leetcode9;

public class Leetcode832 {


    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] cur:image){
            int length=cur.length;
            for(int i=0;i<length/2;i++){
                int temp=cur[i];
                cur[i]=(cur[length-1-i]>0?0:1);
                cur[length-1-i]=(temp==1?0:1);
            }
            if(length%2==1)
                cur[length/2]=(cur[length/2]==1?0:1);

        }
        return image;
    }
}
