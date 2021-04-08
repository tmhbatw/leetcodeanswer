package leetcode.leetcode1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode71 {
    /*Description
    * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
    * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）
    * 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
    * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
    * 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
    * */

    public String simplifyPath(String path) {
        String[] s=path.split("/");
        Deque<String> stack=new ArrayDeque<String>() ;
        for(int i=0;i<s.length;i++){
            if(s[i].length()!=0){
                if(s[i].equals("..")){
                    if(!stack.isEmpty())
                        stack.pollFirst();
                }else if(!s[i].equals("."))
                    stack.push(s[i]);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append('/').append(stack.pollLast());
        }
        return sb.length()==0?"/":sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new Leetcode71().simplifyPath("/a/../../b/../c//.//"));
    }
}
