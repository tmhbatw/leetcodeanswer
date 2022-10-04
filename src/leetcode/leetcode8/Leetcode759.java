package leetcode.leetcode8;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.List;

public class Leetcode759 {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        result.add(new Interval(Integer.MIN_VALUE, Integer.MAX_VALUE));

        for (List<Interval> list : schedule) {
            int j = 0;
            List<Interval> curList = new ArrayList<>();
            for (Interval cur : list) {
                while (cur.end >= result.get(j).end) {
                    if (result.get(j).start < cur.start && cur.start < result.get(j).end) {
                        curList.add(new Interval(result.get(j).start, cur.start));
                    }
                    if (result.get(j).end <= cur.start)
                        curList.add(result.get(j));
                    j++;
                }
                if (cur.start > result.get(j).start && cur.start < result.get(j).end) {
                    curList.add(new Interval(result.get(j).start, cur.start));
                }
                if (cur.end > result.get(j).start) {
                    result.get(j).start = cur.end;
                }
            }

            for (; j < result.size(); j++)
                curList.add(result.get(j));

            result = curList;
        }

        List<Interval> res = new ArrayList<>();
        for (Interval cur : result) {
            if (cur.start == Integer.MIN_VALUE || cur.end == Integer.MAX_VALUE)
                continue;
            res.add(cur);
        }
        return res;
    }
}
