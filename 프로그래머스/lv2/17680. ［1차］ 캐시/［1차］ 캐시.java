import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int cache_hit = 1;
        int cache_miss = 5;
        int answer = 0;
        
       if(cacheSize == 0) 
           return cities.length * cache_miss;
        
       Queue<String> q = new LinkedList<>();
        
        for(int i=0;i<cities.length;i++) {
           String c = cities[i].toLowerCase(); // 대소문자 구분없으므로 소문자로 맞춰줌
            
           if(q.contains(c)) { // cache_hit!
               answer += cache_hit;
               q.remove(c);
               q.add(c);
           } else { // cache_miss
               answer += cache_miss;
               if(q.size() == cacheSize) 
                   q.poll();
               q.add(c);
           }
        }
        return answer;
    }
}