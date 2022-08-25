package leetcode.leetcode11;

public class Leetcode1053 {

    public int[] prevPermOpt1(int[] arr) {
        int min=Integer.MAX_VALUE;
        for(int j=arr.length-1;j>=0;j--){
            if(arr[j]>min){
                int index=getIndex(arr[j],arr,j);
                while(arr[index-1]==arr[index])
                    index--;
                int temp=arr[j];
                arr[j]=arr[index];
                arr[index]=temp;
                return arr;
            }
            min=arr[j];
        }
        return arr;
    }

    private int getIndex(int cur,int[] arr,int i){
        int l=i+1,r=arr.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]>=cur){
                r=mid-1;
            }else{
                l=mid;
            }
        }
        return l;
    }
}
