package leetcode.leetcode10;

public class Leetcode925 {
    public boolean isLongPressedName(String name, String typed) {
        int index2=0;
        int length2=typed.length();
        int length1=name.length();

        for(int i=0;i<length1;i++){
            char cur=name.charAt(i);
            if(index2>=length2||cur!=typed.charAt(index2))
                return false;
            int count=0;
            while(i<length1-1&&name.charAt(i+1)==cur){
                i++;
                count++;
            }
            while(index2<length2-1&&typed.charAt(index2+1)==cur){
                index2++;
                count--;
            }
            if(count>0)
                return false;
            index2++;
        }
        return index2==length2;
    }
}
