package leetcode.leetcode4;

public class Leetcode302 {
    /*Description
    * 图片在计算机处理中往往是使用二维矩阵来表示的。
    * 假设，这里我们用的是一张黑白的图片，那么 0 代表白色像素，1 代表黑色像素。
    * 其中黑色的像素他们相互连接，也就是说，图片中只会有一片连在一块儿的黑色像素（像素点是水平或竖直方向连接的）。
    * 那么，给出某一个黑色像素点 (x, y) 的位置，你是否可以找出包含全部黑色像素的最小矩形（与坐标轴对齐）的面积呢？
    * */

    public int minArea(char[][] image, int x, int y) {
        int minRow=Integer.MAX_VALUE,minCol=Integer.MAX_VALUE,maxRow=0,maxCol=0;
        int row=image.length,col=image[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(image[i][j]=='1'){
                    minRow=Math.min(minRow,i);
                    minCol=Math.min(minCol,j);
                    maxRow=Math.max(maxRow,i);
                    maxCol=Math.max(maxCol,j);
                }
            }
        }
        System.out.println(minCol+""+minRow+" "+maxCol+" "+maxRow);
        return (maxCol-minCol+1)*(maxRow-minRow+1);
    }
}
