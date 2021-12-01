package leetcode.leetcode6;

public class Leetcode531 {

    public int findLonelyPixel(char[][] picture) {
        int row=picture.length,col=picture[0].length;

        int[] rowNumber=new int[row];
        int[] colNumber=new int[col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(picture[i][j]=='B'){
                    rowNumber[i]++;
                    colNumber[j]++;
                }
            }
        }

        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(picture[i][j]=='B'){
                    if(rowNumber[i]==1&&colNumber[j]==1)
                        result++;
                }
            }
        }

        return result;
    }
}
