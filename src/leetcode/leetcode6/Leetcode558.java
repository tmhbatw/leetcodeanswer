package leetcode.leetcode6;

public class Leetcode558 {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

    public Node intersect(Node quadTree1, Node quadTree2) {
        Node cur =new Node();
        if(!quadTree1.isLeaf||!quadTree2.isLeaf){
            addChild(quadTree1);
            addChild(quadTree2);
            cur.topLeft=intersect(quadTree1.topLeft,quadTree2.topLeft);
            cur.topRight=intersect(quadTree1.topRight,quadTree2.topRight);
            cur.bottomLeft=intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
            cur.bottomRight=intersect(quadTree1.bottomRight,quadTree2.bottomRight);
            if(cur.topLeft.isLeaf&&cur.topRight.isLeaf&&cur.bottomRight.isLeaf&&cur.bottomLeft.isLeaf
                &&cur.topLeft.val==cur.topRight.val&&cur.topLeft.val==cur.bottomLeft.val
                &&cur.topLeft.val==cur.bottomRight.val){
                cur.isLeaf=true;
                cur.val=cur.topLeft.val;
                cur.topLeft=null;
                cur.topRight=null;
                cur.bottomLeft=null;
                cur.bottomRight=null;
            }else{
                cur.isLeaf=false;
                cur.val=false;
            }
        }else{
            cur.isLeaf=true;
            cur.val=quadTree1.val|quadTree2.val;
        }

        return cur;
    }

    public Node addChild(Node node){
        if(node.isLeaf){
            node.topLeft=new Node(node.val,true,null,null,null,null);
            node.topRight=new Node(node.val,true,null,null,null,null);
            node.bottomLeft=new Node(node.val,true,null,null,null,null);
            node.bottomRight=new Node(node.val,true,null,null,null,null);
        }
        return node;
    }



}
