package leetcode.leetcode17;

public class Leetcode1634 {
    class PolyNode {
        int coefficient, power;
        PolyNode next = null;

        PolyNode() {}
        PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
        PolyNode(int x, int y, PolyNode next) {
            this.coefficient = x; this.power = y; this.next = next; }
    }

    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode result=new PolyNode();
        PolyNode cur=result;

        while(poly1!=null||poly2!=null){
            int p1=poly1==null?Integer.MIN_VALUE:poly1.power;
            int p2=poly2==null?Integer.MIN_VALUE:poly2.power;

            if(p1==p2){
                int c=poly1.coefficient+poly2.coefficient;
                if(c!=0){
                    cur.next=new PolyNode(c,p1);
                    cur=cur.next;
                }
                poly1=poly1.next;
                poly2=poly2.next;
            }
            if(p1>p2){
                cur.next=new PolyNode(poly1.coefficient,p1);
                poly1=poly1.next;
                cur=cur.next;

            }else if(p1<p2){
                cur.next=new PolyNode(poly2.coefficient,p2);
                poly2=poly2.next;
                cur=cur.next;

            }
        }
        return result.next;
    }
}
