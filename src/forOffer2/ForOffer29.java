package forOffer2;

public class ForOffer29 {

    public int orchestraLayout(int num, int xPos, int yPos) {
        long n=num;
        long layer = Math.min(Math.min(yPos,xPos),Math.min( n - xPos - 1, n - yPos - 1))+1;
        long area= (long) num *num;
        long mid=(num-2*(layer-1));
        mid*=mid;
        long index=(area-mid)%9+1;
        long right=n-layer;
        long left=layer-1;
        if(xPos==left){
            index+=yPos-left;
        }else if(yPos==right){
            index+=right-left;
            index+=xPos-left;
        }else if(xPos==right){
            index+=2*(right-left);
            index+=right-yPos;
        }else{
            index+=3*(right-left);
            index+=right-xPos;
        }
        return (int)(index%9==0?9:index%9);
    }
}
