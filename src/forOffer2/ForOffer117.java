package forOffer2;

public class ForOffer117 {

    public int numSimilarGroups(String[] strs) {
        int[] type=new int[strs.length];
        for(int i=0;i<type.length;i++){
            type[i]=i;
        }
        int res=strs.length;
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                if(getDiff(strs[i],strs[j])){
                    int type1=getType(type,i);
                    int type2=getType(type,j);
                    if(type1==type2)
                        continue;
                    type[type2]=type1;
                    res--;
                }
            }
        }
        return res;
    }

    private boolean getDiff(String s1,String s2){
        int diff=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                diff++;
        }
        return diff==2||diff==0;
    }

    private int getType(int[] type, int cur){
        if(type[cur]==cur)
            return cur;
        return getType(type,type[cur]);
    }
}
