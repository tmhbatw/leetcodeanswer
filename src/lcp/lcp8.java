package lcp;

public class lcp8 {

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] c=new int[increase.length+1];
        int[] r=new int[increase.length+1];
        int[] h=new int[increase.length+1];

        for(int i=0;i<increase.length;i++){
            c[i+1]=c[i]+increase[i][0];
            r[i+1]=r[i]+increase[i][1];
            h[i+1]=h[i]+increase[i][2];
        }

        int[] result=new int[requirements.length];
        for(int i=0;i<requirements.length;i++){
            result[i] = getRes(requirements[i],c,r,h);
        }
        return result;
    }

    private int getRes(int[] cur, int[] c,int[] r,int[] h){
        int curr=Math.max(getRes(c,cur[0]),getRes(r,cur[1]));
        curr=Math.max(curr,getRes(h,cur[2]));
        return curr==Integer.MAX_VALUE?-1:curr;
    }

    private int getRes(int[] cur, int i){
        if(i>cur[cur.length-1])
            return Integer.MAX_VALUE;
        int l=0,r=cur.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(cur[mid]>=i){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;

    }


}
