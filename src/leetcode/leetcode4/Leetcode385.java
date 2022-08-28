package leetcode.leetcode4;

import datastructure.NestedInteger;

import java.util.List;

public class Leetcode385 {

    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger(){

        }

        public NestedInteger(int val){

        }

        // Constructor initializes a single integer.

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger(){
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value){

        }
        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){
            return null;
        }
    }


    int index=0;

    public NestedInteger deserialize(String s) {
        if(s.charAt(index)=='['){
            NestedInteger result=new NestedInteger();
            index++;
            while(s.charAt(index)!=']'){
                if(s.charAt(index)==','){
                    index++;
                    continue;
                }
                result.add(deserialize(s));
            }
            index++;
            return result;
        }else{
            boolean positive=true;
            if(s.charAt(index)=='-') {
                positive = false;
                index++;
            }
            int cur = s.charAt(index)-'0';
            while(index<s.length()-1&&s.charAt(index+1)<='9'&&s.charAt(index+1)>='0'){
                cur =cur*10+s.charAt(++index)-'0';
            }
            cur = positive?cur:-cur;
            index++;
            return (new NestedInteger(cur));
        }
    }

//    public NestedInteger deserialize(String s) {
//        NestedInteger result = new NestedInteger();
//        while(index<s.length()){
//            if(s.charAt(index)=='['){
//                index++;
//                result.add(deserialize(s));
//            }else if(s.charAt(index)==']'){
//                index++;
//                return result;
//            }else if(s.charAt(index)==','){
//                index++;
//            }else{
//                boolean positive=true;
//                if(s.charAt(index)=='-') {
//                    positive = false;
//                    index++;
//                }
//                int cur = s.charAt(index)-'0';
//                while(index<s.length()-1&&s.charAt(index+1)<='9'&&s.charAt(index+1)>='0'){
//                    cur =cur*10+s.charAt(++index)-'0';
//                }
//                cur = positive?cur:-cur;
//                result.add(new NestedInteger(cur));
//
//                // System.out.println(cur);
//                // System.out.println(result);
//                index++;
//            }
//        }
//        return result;
//    }
}
