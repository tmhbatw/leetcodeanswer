package leetcode.leetcode12;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1166 {

    class FileSystem {

        Map<String,FileSystem> m;
        int val;
        public FileSystem() {
            this.m=new HashMap<>();
        }

        public boolean createPath(String path, int value) {
            String[] s=path.split("/");
            Map<String,FileSystem> cur=m;
            for(int i=1;i<s.length-1;i++){
                if(!cur.containsKey(s[i]))
                    return false;
                cur=cur.get(s[i]).m;
            }
            if(cur.containsKey(s[s.length-1]))
                return false;
            cur.put(s[s.length-1],new FileSystem());
            cur.get(s[s.length-1]).val=value;
            return true;
        }

        public int get(String path) {
            String[] s=path.split("/");
            FileSystem cur=this;
            for(int i=1;i<s.length;i++){
                if(!cur.m.containsKey(s[i]))
                    return -1;
                cur=cur.m.get(s[i]);
            }
            return cur.val;
        }
    }
}
