package leetcode.leetcode13;

public class Leetcode1201 {

    int a;
    int b;
    int c;
    long d;
    long e;
    long f;
    long g;
    public int nthUglyNumber(int n, int a, int b, int c) {
        int l=1,r=Integer.MAX_VALUE;
        setValue(a,b,c);
        while(l<r){
            int mid=l+(r-l)/2;
            if(match(n,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    private void setValue(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
        long ab = getRes(Math.min(a,b),Math.max(a,b));
        long ac=getRes(Math.min(a,c),Math.max(a,c));
        long bc=getRes(Math.min(b,c),Math.max(b,c));
        this.d=  ((long)a*b/ab);
        this.e=(long)a*c/ac;
        this.f=(long)b*c/bc;
        long dc=getRes(Math.min(d,c),Math.max(d,c));
        this.g=(long) d*c/dc;
    }

    private long getRes(long a,long b){
        if(b%a==0)
            return a;
        return getRes(b%a,a);
    }

    private boolean match(int n,int mid){
        long count = 0;
        count += (long)mid/a+mid/b+mid/c-mid/d-mid/e-mid/f+mid/g;
        return count >=n;
    }


}
