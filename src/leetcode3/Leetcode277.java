package leetcode3;

public class Leetcode277 {
    /*Description
    * 假设你是一个专业的狗仔，参加了一个n人派对，其中每个人被从0到n - 1标号。在这个派对人群当中可能存在一位“名人”。
    * 所谓 “名人” 的定义是：其他所有n - 1个人都认识他/她，而他/她并不认识其他任何人。
    * 现在你想要确认这个 “名人” 是谁，或者确定这里没有“名人”。而你唯一能做的就是问诸如
    * “A你好呀，请问你认不认识B呀？”的问题，以确定 A 是否认识 B。你需要在（渐近意义上）
    * 尽可能少的问题内来确定这位 “名人” 是谁（或者确定这里没有 “名人”）。
    * 在本题中，你可以使用辅助函数bool knows(a, b)获取到 A是否认识 B。
    * 请你来实现一个函数int findCelebrity(n)。
    * 派对最多只会有一个 “名人” 参加。若“名人” 存在，请返回他/她的编号；若“名人”不存在，请返回-1。
    * */

    boolean knows(int a, int b){
        int random=(int)(Math.random()*2);
        return random>=1;

    }

    public int findCelebrity(int n) {
        int pre=0;
        for(int i=1;i<n;i++){
            if(knows(pre,i)){
                pre=i;
            }
        }
        for(int i=0;i<n;i++){
            if(!knows(i,pre))
                return -1;
            if(i==pre)
                continue;
            if(knows(pre,i))
                return -1;
        }
        return pre;
    }
}
