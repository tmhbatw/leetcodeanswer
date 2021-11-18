package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class Leetcode726 {
    class Node{
        String s;
        int time;
        public Node(String s,int time){
            this.s=s;
            this.time=time;
        }
    }

    public String countOfAtoms(String formula) {
        Stack<Node> s=new Stack<>();
        int length=formula.length();
        for(int i=0;i<length;i++){
            if(formula.charAt(i)=='(')
                s.add(new Node("(",0));
            else if(formula.charAt(i)==')'){
                int time=0;
                while(i<length-1&&formula.charAt(i+1)<='9'&&formula.charAt(i+1)>='0'){
                    time=time*10+formula.charAt(++i)-'0';
                }
                time=Math.max(time,1);
                List<Node> list=new ArrayList<>();
                while(!s.peek().s.equals("(")){
                    Node cur=s.pop();
                    cur.time*=time;
                    list.add(cur);
                }
                s.pop();
                s.addAll(list);
            }else{
                StringBuilder sb=new StringBuilder();
                sb.append(formula.charAt(i));
                while(i<length-1&&formula.charAt(i+1)<='z'&&formula.charAt(i+1)>='a'){
                    sb.append(formula.charAt(++i));
                }
                int time=0;
                while(i<length-1&&formula.charAt(i+1)<='9'&&formula.charAt(i+1)>='0'){
                    time=time*10+formula.charAt(++i)-'0';
                }
                s.add(new Node(sb.toString(),Math.max(1,time)));
            }
        }
        TreeMap<String,Integer> map=new TreeMap<>();
        for(Node cur:s){
            map.put(cur.s,map.getOrDefault(cur.s,0)+cur.time);
        }
        StringBuilder result=new StringBuilder();
        for(String key:map.keySet()){
            result.append(key).append((map.get(key)>1?map.get(key):""));

        }
        return result.toString();
    }
}
