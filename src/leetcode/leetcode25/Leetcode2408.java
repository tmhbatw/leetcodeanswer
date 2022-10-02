package leetcode.leetcode25;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2408 {

    class SQL {

        Map<String,Integer> rowId;
        Map<String,Map<Integer,List<String>>> tables;
        public SQL(List<String> names, List<Integer> columns) {
            this.rowId=new HashMap<>();
            this.tables=new HashMap<>();
            for(String name:names){
                rowId.put(name,1);
                tables.put(name,new HashMap<>());
            }
        }

        public void insertRow(String name, List<String> row) {
            int cur=rowId.get(name);
            rowId.put(name,cur+1);

            tables.get(name).put(cur,row);
        }

        public void deleteRow(String name, int rowId) {
            tables.get(name).remove(rowId);
        }

        public String selectCell(String name, int rowId, int columnId) {
            List<String> list=tables.get(name).get(rowId);
            return list.get(columnId-1);
        }
    }
}
