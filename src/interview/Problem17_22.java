package interview;

import java.util.*;

public class Problem17_22 {

    class Node{
        List<Integer> list;
        int cur;
        public Node(List<Integer> l,int curr){
            this.list=new ArrayList<>();
            this.list.addAll(l);
            this.list.add(curr);
            this.cur=curr;
        }
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> result=new ArrayList<>();
        if(!wordList.contains(endWord))
            return result;

        Map<Integer,List<Integer>> map=new HashMap<>();
        getRelation(map,wordList);

        boolean[] reached=new boolean[wordList.size()];
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<wordList.size();i++){
            if(isSimilar(beginWord,wordList.get(i))){
                reached[i]=true;
                q.add(new Node(new ArrayList<>(),i));
            }
        }

        while(!q.isEmpty()){
            Node node=q.poll();
            List<Integer> list=map.get(node.cur);
            for(int next:list){
                if(wordList.get(next).equals(endWord)){
                    result.add(beginWord);
                    for(int n:node.list)
                        result.add(wordList.get(n));
                    result.add(endWord);
                    return result;
                }
                if(reached[next])
                    continue;
                q.add(new Node(node.list,next));
                reached[next]=true;
            }
        }

        return result;
    }

    private void getRelation(Map<Integer,List<Integer>>map,List<String> wordList){
        for(int i=0;i<wordList.size();i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<wordList.size();i++){
            for(int j=i+1;j<wordList.size();j++){
                if(isSimilar(wordList.get(i),wordList.get(j))){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
    }

    private boolean isSimilar(String s1,String s2){
        int diff=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                diff++;
        }
        return diff==1;
    }
}
