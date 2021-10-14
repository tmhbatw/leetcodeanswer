package leetcode.leetcode11;

public class Leetcode1089 {

    public void duplicateZeros(int[] arr) {
        int count=0;
        int i=0;
        for(;i<arr.length;i++){
            count++;
            if(arr[i]==0)
                count++;
            if(count>=arr.length)
                break;
        }
        int j=arr.length-1;
        if(count>arr.length){
            arr[j--]=0;
            i--;
        }
        System.out.println(i+" "+count);
        for(;j>=0;j--){
            if(arr[i]==0){
                arr[j]=0;
                arr[--j]=0;
            }else
                arr[j]=arr[i];
            i--;
        }
    }
}
