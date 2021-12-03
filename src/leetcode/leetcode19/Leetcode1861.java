package leetcode.leetcode19;

public class Leetcode1861 {

    public char[][] rotateTheBox(char[][] box) {
        int row=box.length,col=box[0].length;
        char[][] res=new char[col][row];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                res[j][row-i-1]=box[i][j];
        }
        for(int j=0;j<res[0].length;j++){

            int ii=res.length-1;
            for(int i=res.length-1;i>=0;i--){
                if(res[i][j]=='*')
                    continue;
                ii=Math.min(ii,i);
                while(ii>=0&&res[ii][j]=='.'){
                    ii--;
                }
                if(ii<0||res[ii][j]=='*'){
                    res[i][j]='.';
                }else{
                    res[i][j]='#';
                    ii--;
                }
            }
        }


        return res;
    }
}
