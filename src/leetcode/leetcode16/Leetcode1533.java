package leetcode.leetcode16;

public class Leetcode1533 {

    interface ArrayReader {
        // Compares the sum of arr[l..r] with the sum of arr[x..y]
        // return 1 if sum(arr[l..r]) > sum(arr[x..y])
        // return 0 if sum(arr[l..r]) == sum(arr[x..y])
        // return -1 if sum(arr[l..r]) < sum(arr[x..y])
        public int compareSub(int l, int r, int x, int y);
        // Returns the length of the array
        public int length();
    }

    public int getIndex(ArrayReader reader) {
        int length=reader.length();
        return getIndex(reader,0,length-1);
    }

    private int getIndex(ArrayReader reader, int i, int j){
        if(i==j)
            return i;

        int mid=(i+j)/2;
        if(mid-i>j-mid-1){
            int cur=reader.compareSub(i,mid-1,mid+1,j);
            if(cur==0)
                return mid;
            if(cur>0)
                return getIndex(reader,i,mid-1);
            else
                return getIndex(reader,mid+1,j);
        }
        int cur=reader.compareSub(i,mid,mid+1,j);
        if(cur>0)
            return getIndex(reader,i,mid);
        return getIndex(reader,mid+1,j);

    }
}
