package leetcode.leetcode15;

import java.util.List;

public class Leetcode1428 {

     interface BinaryMatrix {
         public int get(int row, int col) ;
         public List<Integer> dimensions() ;
     };
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list=binaryMatrix.dimensions();

        int row=list.get(0);
        int col=list.get(1);

        int result=col;
        for(int i=0;i<row;i++){

            int l=0,r=col-1;
            if(binaryMatrix.get(i,r)==0)
                continue;
            while(l<r){
                int mid=(l+r)/2;
                if(binaryMatrix.get(i,mid)==0)
                    l=mid+1;
                else
                    r=mid;
            }
            result=Math.min(result,l);
        }
        return result==col?-1:result;
    }
}
