package leetcode.leetcode23;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode2271 {

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(o -> o[0]));

        int[] res=new int[tiles.length+1];
        for(int i =0;i<tiles.length;i++){
            res[i+1]=res[i]+tiles[i][1]-tiles[i][0]+1;
        }



        int result = 0;
        for(int i=0;i<tiles.length;i++){
            int start = tiles[i][0];
            int end = start+carpetLen;
            if(end>tiles[tiles.length-1][1])
                return Math.max(result,res[res.length-1]-res[i]);

            int l =i,r=tiles.length-1;
            while(l<r){
                int mid = (l+r)/2;
                if(tiles[mid][0]<=end&&end<=tiles[mid][1]){
                    l=mid;
                    break;
                }
                if(tiles[mid][1]<end){
                    l=mid+1;
                }
                else
                    r=mid;
            }

            int cur = res[l]-res[i]+Math.max(0,end-tiles[l][0]);
            result=Math.max(result,cur);
        }

        return result;
    }


}
