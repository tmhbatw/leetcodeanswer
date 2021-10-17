package lcs;

public class Lcs1 {

    public int leastMinutes(int n) {
        int count=1;
        int base=1;
        while(base<n){
            base*=2;
            count++;
        }
        return count;
    }
}
