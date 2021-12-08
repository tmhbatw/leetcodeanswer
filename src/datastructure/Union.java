package datastructure;

public  class Union{
    int[] time;
    int[] type;
    public Union(int n){
        this.time=new int[n+1];
        this.type=new int[n+1];
        for(int i=0;i<time.length;i++){
            time[i]=1;
            type[i]=i;
        }
    }

    private int getType(int n){
        if(type[n]==n)
            return n;
        return getType(type[n]);
    }

    private boolean union(int a,int b){
        int t1=getType(a);
        int t2=getType(b);

        if(t1==t2)
            return false;
        if(time[t1]<time[t2]){
            time[t2]+=time[t1];
            type[t1]=t2;
        }else{
            time[t1]+=time[t2];
            type[t2]=t1;
        }
        return true;
    }
}