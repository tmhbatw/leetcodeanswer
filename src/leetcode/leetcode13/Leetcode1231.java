package leetcode.leetcode13;

public class Leetcode1231 {

    public int maximizeSweetness(int[] sweetness, int k) {
        int l=1,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l+1)/2;
            if(isMatch(sweetness,mid,k))
                l=mid;
            else
                r=mid-1;
        }
        return l;
    }

    private boolean isMatch(int[] sweet,int mid,int k){
        int length=sweet.length;
        for(int i=0;i<length;i++){
            int sum=sweet[i];
            while(sum<mid&&i<length-1){
                sum+=sweet[++i];
            }

            if(sum>=mid)
                k--;
        }
        return k<0;
    }
}
