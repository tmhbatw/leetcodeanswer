package leetcode.leetcode10;

public class Leetcode904 {

    public int totalFruit(int[] fruits) {
        int j=0;
        int result=0;
        int length=fruits.length;

        int f1=-1;
        int f2=-1;
        int c1=0;
        int c2=0;

        for(int i=0;i<length;i++){
            while(j<length){
                if(fruits[j]==f1){
                    c1++;
                    j++;
                }
                else if(fruits[j]==f2){
                    c2++;
                    j++;
                }else if(f1==-1){
                    f1=fruits[j++];
                    c1=1;
                }else if(f2==-1) {
                    f2 = fruits[j++];
                    c2 = 1;
                }else
                    break;
            }

            result=Math.max(result,j-i);

            while(i<j){
                if(fruits[i]==f1){
                    c1--;
                    if(c1==0){
                        f1=-1;
                        break;
                    }
                }
                if(fruits[i]==f2){
                    c2--;
                    if(c2==0){
                        f2=-1;
                        break;
                    }
                }
                i++;
            }
        }

        return result;
    }
}
