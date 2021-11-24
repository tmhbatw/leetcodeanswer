package leetcode.leetcode12;

import java.util.Locale;

public class Leetcode1138 {

    int row=0;
    int col=0;
    public String alphabetBoardPath(String target) {
        int row=0;
        int col=0;
        StringBuilder result=new StringBuilder();

        for(char c:target.toCharArray()){
            int[] pos=getPos(c);
            if(c=='z'){
                move2(pos,result);
                move1(pos,result);
            }else{
                move1(pos,result);
                move2(pos,result);
            }

            result.append('!');
        }
        return result.toString();
    }

    private void move1(int[] pos, StringBuilder result){
        while(row!=pos[0]){
            if(row<pos[0]){
                row++;
                result.append('D');
            }
            else{
                row--;
                result.append('U');
            }
        }
    }

    private void move2(int[] pos,StringBuilder result){
        while(col!=pos[1]){
            if(col<pos[1]){
                col++;
                result.append('R');
            }else{
                col--;
                result.append('L');
            }
        }
    }


    private int[] getPos(char c){
        int time=c-'a';
        return new int[]{time/5,time%5};
    }
}
