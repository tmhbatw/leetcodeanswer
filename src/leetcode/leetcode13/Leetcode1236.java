package leetcode.leetcode13;

import java.util.*;

public class Leetcode1236 {
    interface HtmlParser {
        public List<String> getUrls(String url) ;
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> result=new HashSet<>();
        result.add(startUrl);
        String target=getDomain(startUrl);

        Stack<String> s=new Stack<>();
        s.add(startUrl);

        while(!s.isEmpty()){
            String cur=s.pop();
            List<String> l=htmlParser.getUrls(cur);

            for(String next:l){
                if(getDomain(next).equals(target)&&!result.contains(next)){
                    result.add(next);
                    s.add(next);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private String getDomain(String url){
        url=url.substring(7);
        return url.split("/")[0];
    }
}
