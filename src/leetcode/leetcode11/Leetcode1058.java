package leetcode.leetcode11;

import java.text.DecimalFormat;
import java.util.*;

public class Leetcode1058 {

    public String minimizeError(String[] prices, int target) {
        List<Double> list=new ArrayList<>();
        for(String price:prices){
            double d=Double.parseDouble(price);

            double floor=Math.floor(d);
            double ceil=Math.ceil(d);
            target-=floor;

            if(floor!=ceil){
                list.add(d-floor);

            }

        }

        if(target<0||target-list.size()>0)
            return "-1";

        double result=0;
        Collections.sort(list);

        //target个1，list.size()-target个0；
        for(int i=0;i<list.size();i++){
            if(i<list.size()-target)
                result+=list.get(i);
            else
                result+=1-list.get(i);
        }

        if(result==0.0)
            return "0.000";
        DecimalFormat df=new DecimalFormat("#.000");
        return df.format(result);
    }
}
