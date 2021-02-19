package leetcode7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode690 {
    /*Description
    * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度和 直系下属的id。
    * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，
    * 员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
    * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
    * */

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    Map<Integer,Integer> map;
    List<Employee> employees;
    public int getImportance(List<Employee> employees, int id) {
        map=new HashMap<>();
        this.employees=employees;
        for(int i=0;i<employees.size();i++){
            map.put(employees.get(i).id,i);
        }
        return getImportance(id);
    }

    private int getImportance(int id){
        Employee employee=employees.get(map.get(id));
        int result=employee.importance;
        for(int cur:employee.subordinates){
            result+=getImportance(cur);
        }
        return result;
    }
}
