package forOffer2;

public class ForOffer72 {

    public int mySqrt(int x) {
        int l=0,r=46340;
        while(l<r){
            int mid=(l+r+1)/2;
            if(mid*mid>x)
                r=mid-1;
            else
                l=mid;
        }
        return l;
    }

    public static void main(String[] args){
        System.out.println(new ForOffer72().mySqrt(Integer.MAX_VALUE-1));
    }

}
