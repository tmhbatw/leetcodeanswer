package leetcode.leetcode23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode2251 {

    class Person{
        int visit;
        int index;

        public Person(int visit,int index){
            this.visit=visit;
            this.index=index;
        }
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        Arrays.sort(flowers, Comparator.comparingInt(o -> o[0]));
        Person[] p=new Person[persons.length];
        for(int i=0;i<persons.length;i++){
            p[i]=new Person(persons[i],i);
        }
        Arrays.sort(p, Comparator.comparingInt(o -> o.visit));

        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.comparingInt(o -> o));
        int index= 0 ;
        int[] result= new int[persons.length];
        for (Person person : p) {
            while (index < flowers.length && flowers[index][0] <= person.visit)
                pq.add(flowers[index++][1]);

            while (!pq.isEmpty() && pq.peek() < person.visit)
                pq.poll();
            result[person.index] = pq.size();
        }

        return result;
    }

}
