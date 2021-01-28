package leetcode4;

public class Leetcode379 {
    /*Description
    *设计一个电话目录管理系统，让它支持以下功能：
    * get: 分配给用户一个未被使用的电话号码，获取失败请返回 -1
    * check: 检查指定的电话号码是否被使用
    * release: 释放掉一个电话号码，使其能够重新被分配
    * */

    class PhoneDirectory {
        boolean[] reached;
        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            reached=new boolean[maxNumbers];
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            for(int i=0;i<reached.length;i++){
                if(!reached[i]){
                    reached[i]=true;
                    return i;
                }
            }
            return -1;
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            return !reached[number];
        }

        /** Recycle or release a number. */
        public void release(int number) {
            reached[number]=false;
        }
    }
}
