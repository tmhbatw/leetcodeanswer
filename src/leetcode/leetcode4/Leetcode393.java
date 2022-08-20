package leetcode.leetcode4;

public class Leetcode393 {

    public boolean validUtf8(int[] data) {
        for(int i=0;i<data.length;i++){
            int curCount = getCount(data[i]);
            //System.out.println(curCount);
            if(curCount==0)
                continue;
            if(curCount==1||curCount>4)
                return false;
            if(i+curCount-1>=data.length)
                return false;
            while(--curCount>0){
                if(getCount(data[++i])!=1)
                    return false;
            }
        }
        return true;
    }

    private int getCount(int cur){
        boolean[] b=new boolean[8];
        for(int j=7;j>=0;j--){
            if(cur%2==1)
                b[j]=true;
            cur/=2;
        }
        for(int i=0;i<8;i++){
            if(!b[i])
                return i;
        }
        return 8;
    }
}
