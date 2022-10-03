package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.List;

public class Leetcode428 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if(root==null)
                return "";
            StringBuilder sb=new StringBuilder();
            serialize(root,sb);
            return sb.toString();
        }

        public void serialize(Node root, StringBuilder sb){
            sb.append("(");
            sb.append(root.val);

            for(Node child:root.children){
                serialize(child,sb);
            }
            sb.append(")");
        }

        int index;
        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if(data.length()==0)
                return null;

            data=data.substring(1,data.length()-1);
            System.out.println(data);
            this.index=0;
            return getRes(data);
        }

        public Node getRes(String data){
            //System.out.println("进入index的值为："+index);
            Node result=new Node();
            result.children=new ArrayList<>();
            for(;index<data.length();index++){
                if(data.charAt(index)=='('){
                    index++;
                    result.children.add(getRes(data));
                    continue;
                }
                if(data.charAt(index)==')'){
                    //System.out.println("离开index的值为："+index);
                    return result;
                }
                int cur=0;
                while(index<data.length()&&data.charAt(index)<='9'&&data.charAt(index)>='0'){
                    cur=cur*10+data.charAt(index++)-'0';
                }
                index--;
                result.val=cur;
            }

            return result;
        }
    }
}
