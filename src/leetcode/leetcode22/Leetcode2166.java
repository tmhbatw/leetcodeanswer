package leetcode.leetcode22;

public class Leetcode2166 {

    class Bitset {
        boolean reverse = false;
        int[] num;
        int oneTime=0;

        public Bitset(int size) {
            this.num=new int[size];
        }

        private void putZero(int idx){
            if(num[idx]==1){
                num[idx]=0;
                oneTime--;
            }
        }

        private void putOne(int idx){
            if(num[idx]==0){
                num[idx]=1;
                oneTime++;
            }
        }

        public void fix(int idx) {
            if(reverse){
                putZero(idx);
            }else
                putOne(idx);
        }

        public void unfix(int idx) {
            if(reverse){
                putOne(idx);
            }else
                putZero(idx);
        }

        public void flip() {
            reverse=!reverse;
        }

        public boolean all() {
            int cur=oneTime;
            if(reverse){
                cur=num.length-oneTime;
            }
            return cur==num.length;
        }

        public boolean one() {
            int cur=oneTime;
            if(reverse)
                cur=num.length-oneTime;
            return cur>=1;
        }

        public int count() {
            int cur=oneTime;
            if(reverse){
                cur=num.length-oneTime;
            }
            return cur;
        }

        public String toString() {
            StringBuilder sb=new StringBuilder();
            for(int num:num){
                if(reverse){
                    sb.append(num==1?0:1);
                }else
                    sb.append(num);
            }
            return sb.toString();
        }
    }

}
