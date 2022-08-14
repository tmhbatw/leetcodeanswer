package leetcode.leetcode14;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1396 {

    class UndergroundSystem {

        Map<String, Map<String,Record>> map;
        Map<Integer,EntryStation> m;
        public UndergroundSystem() {
            this.map=new HashMap<>();
            this.m=new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            m.put(id,new EntryStation(stationName,t));
        }

        public void checkOut(int id, String stationName, int t) {
            EntryStation e=m.get(id);
            map.putIfAbsent(e.name,new HashMap<>());
            map.get(e.name).putIfAbsent(stationName,new Record());

            Record r=map.get(e.name).get(stationName);
            r.time++;
            r.dis+=t-e.time;
        }

        public double getAverageTime(String startStation, String endStation) {
            Record r=map.get(startStation).get(endStation);
            return r.dis*1.0/r.time;
        }
    }

    class Record{
        int dis;
        int time;
        public Record(){
            this.dis=0;
            this.time=0;
        }
    }

    class EntryStation{
        String name;
        int time;
        public EntryStation(String name,int time){
            this.name=name;
            this.time=time;
        }
    }
}
