package leetcode.leetcode6;

import java.util.ArrayList;
import java.util.List;

public class Leetcode533 {

    public int findBlackPixel(char[][] picture, int target) {
        int r=picture.length;
        int c=picture[0].length;
        int[] row=new int[r];
        List<List<Integer>> list=new ArrayList<>();
        for(int j=0;j<c;j++)
            list.add(new ArrayList<>());

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(picture[i][j]=='B'){
                    row[i]++;
                    list.get(j).add(i);
                }
            }
        }
        boolean[] col=new boolean[c];
        for(int j=0;j<c;j++){
            if(list.get(j).size()==target&&isSame(list.get(j),picture))
                col[j]=true;
        }

        int result=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(row[i]==target&&col[j]&&picture[i][j]=='B'){
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isSame(List<Integer> list,char[][] picture){
        for(int i=1;i<list.size();i++){
            if(!new String(picture[list.get(0)]).equals(new String(picture[list.get(i)])))
                return false;
        }
        return true;
    }



}
