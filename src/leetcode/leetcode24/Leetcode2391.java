package leetcode.leetcode24;

public class Leetcode2391 {

    public int garbageCollection(String[] garbage, int[] travel) {
        int result=0;
        for(char c:new char[]{'M','P','G'}) {
            int t=0;
            for (int i = 0; i < garbage.length; i++) {
                int count=0;
                for(char cc:garbage[i].toCharArray()){
                    if(cc==c)
                        count++;
                }

                if(count>0){
                    result+=count;
                    result+=t;
                    t=0;
                }
                if(i<travel.length){
                    t+=travel[i];
                }
            }
        }

        return result;
    }

}
