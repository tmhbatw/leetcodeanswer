package leetcode.leetcode25;

import java.util.Arrays;

public class Leetcode2418 {

    class People{
        String name;
        int height;
        public People(String name, int height){
            this.name=name;
            this.height=height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        People[] p=new People[names.length];
        for(int i=0;i<names.length;i++)
            p[i]=new People(names[i],heights[i]);
        Arrays.sort(p,(o1,o2)-> o2.height-o1.height);
        for(int i=0;i<names.length;i++)
            names[i]=p[i].name;
        return names;
    }

}
