package leetcode.leetcode7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode609 {
    /*Description
    * 给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，您需要找到文件系统中的所有重复文件组的路径。
    * 一组重复的文件至少包括二个具有完全相同内容的文件。输入列表中的单个目录信息字符串的格式如下：
    * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
    * 这意味着有 n 个文件（f1.txt,f2.txt...fn.txt 的内容分别是 f1_content,f2_content...fn_content）
    * 在目录root/d1/d2/.../dm下。注意：n>=1 且 m>=0。如果 m=0，则表示该目录是根目录。
    * 该输出是重复文件路径组的列表。对于每个组，它包含具有相同内容的文件的所有文件路径。文件路径是具有下列格式的字符串：
    * "directory_path/file_name.txt"
    * */

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map=new HashMap<>();
        for(String cur:paths){
            String[] path=cur.split(" ");
            for(int i=1;i<path.length;i++){
                String[] content=path[i].split("\\(");
                String c=content[1].substring(0,content[1].length()-1);
                String p=path[0]+"/"+content[0];
                List<String> list=map.getOrDefault(c,new ArrayList<>());
                list.add(p);
                map.put(c,list);
            }
        }
        List<List<String>> result=new ArrayList<>();
        for(Map.Entry entry:map.entrySet()){
            List<String> list= (List<String>) entry.getValue();
            if(list.size()>1)
                result.add(list);
        }
        return result;
    }
}
