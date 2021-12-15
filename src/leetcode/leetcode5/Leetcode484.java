package leetcode.leetcode5;

public class Leetcode484 {

    public int[] findPermutation(String s) {
        int length=s.length();
        int[] res=new int[length+1];
        for(int i=0;i<res.length;i++)
            res[i]=i+1;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='D'){
                int start=i;
                while(i<s.length()-1&&s.charAt(i+1)=='D')
                    i++;
                swap(res,start,i+1);
            }
        }
        return res;
    }

    private void swap(int[] res,int i,int j){
        while(i<j){
            int temp=res[i];
            res[i++]=res[j];
            res[j--]=temp;
        }
    }
}
