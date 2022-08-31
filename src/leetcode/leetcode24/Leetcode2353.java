package leetcode.leetcode24;

import java.util.*;

public class Leetcode2353 {

    class Food {
        String name;
        int rating;

        public Food(String name,int rating){
            this.name = name;
            this.rating = rating;
        }
    }

    class FoodRatings {

        List<Map<String,Integer>> change;
        List<PriorityQueue<Food>> list;
        Map<String,Integer> type;
        Map<String,String> map;
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            type = new HashMap<>();
            list=new ArrayList<>();
            change = new ArrayList<>();
            map=new HashMap<>();
            int index=0;

            for(String cur :cuisines){
                if(!type.containsKey(cur)){
                    type.put(cur,index++);
                    change.add(new HashMap<>());
                    list.add(new PriorityQueue<>((o1,o2)->{
                        if (o1.rating==o2.rating)
                            return o1.name.compareTo(o2.name);
                        return o2.rating-o1.rating;
                    }));
                }
            }

            for(int i=0;i<foods.length;i++){
                map.put(foods[i],cuisines[i]);
                list.get(type.get(cuisines[i])).add(new Food(foods[i],ratings[i]));
            }

        }

        public void changeRating(String food, int newRating) {
            int index=type.get(map.get(food));
            list.get(index).add(new Food(food,newRating));
            change.get(index).put(food,newRating);
        }

        public String highestRated(String cuisine) {
            int index=type.get(cuisine);
            Queue<Food> q=list.get(index);

            while(!q.isEmpty()){
                Food first=q.peek();
                if(change.get(index).containsKey(first.name)&&
                   change.get(index).get(first.name)!=first.rating)
                    q.poll();
                else
                    break;
            }
            return q.peek().name;
        }
    }


}
