package forOffer2;

public class ForOffer118 {

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] type=new int[n];
        for(int i=0;i<type.length;i++)
            type[i]=i;
        for(int[] edge:edges){
            int min=Math.min(edge[0],edge[1]);
            int max=Math.max(edge[0],edge[1]);
            int type1=getType(type,min);
            int type2=getType(type,max);
            if(type1==type2)
                return edge;
            type[type2]=type1;
        }
        return null;
    }

    private int getType(int[] type, int cur){
        if(type[cur]==cur)
            return cur;
        return getType(type,type[cur]);
    }
}
