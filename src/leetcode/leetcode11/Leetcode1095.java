package leetcode.leetcode11;

public class Leetcode1095 {

    interface MountainArray {
        public int get(int index);
        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length=mountainArr.length();
        int l=0,r=length-1;
        while(l<r){
            int mid=(l+r)/2;
            int cur1=mountainArr.get(mid);
            int cur2=mountainArr.get(mid+1);
            if(cur2<cur1){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        int mid=l;
        l=0;
        r=mid;
        while(l<=r){
            int m=(l+r)/2;
            int cur=mountainArr.get(m);
            if(cur==target)
                return m;
            if(cur<target)
                l=m+1;
            else
                r=m-1;
        }
        l=mid+1;
        r=length-1;
        while(l<=r){
            int m=(l+r)/2;
            int cur=mountainArr.get(m);
            if(cur==target)
                return m;
            if(cur<target)
                r=m-1;
            else
                l=m+1;
        }
        return -1;
    }
}
