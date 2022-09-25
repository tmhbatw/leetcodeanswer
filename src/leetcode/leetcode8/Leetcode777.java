package leetcode.leetcode8;

public class Leetcode777 {

    //从start的角度来说，可以多r，可以少l，但不能同时多r并少l
    public boolean canTransform(String start, String end) {
        int r=0,l=0;
        for(int i=0;i< start.length();i++){
            switch (start.charAt(i)){
                case 'R':
                    if(l>0)
                        return false;
                    r++;
                    break;
                case 'L':
                    if(r>0)
                        return false;
                    l--;
                    break;
            }
            switch (end.charAt(i)){
                case 'R':
                    r--;
                    break;
                case 'L':
                    l++;
            }
            if(l<0||r<0){
                return false;
            }
        }
        return r==0&&l==0;
    }
}
