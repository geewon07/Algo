import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str1, String str2) {
        String st1 = str1.toLowerCase();
        String st2 = str2.toLowerCase();
        
        List<String> list1 = Stringtolist(st1);
        List<String> list2 = Stringtolist(st2);
        
        double same = samelist(list1, list2);
        double all = list1.size() + list2.size() - same;
        if(all == 0)
           return 65536;
        
        double ans = Math.floor(same/all*65536);
        return (int)ans;
     }
    List<String> Stringtolist(String s) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<s.length()-1;i++ ) {
            String s2 = "";
            s2 += s.charAt(i);
            s2 += s.charAt(i+1);
            if('a'<= s2.charAt(0) && s2.charAt(0) <= 'z' && 'a' <= s2.charAt(1) && s2.charAt(1) <= 'z') 
                list.add(s2);
        }
        list.sort(null);
        return list;
    }
    
    int samelist(List list1, List list2) {
    int count = 0;
    int index = 0;
      for(int i=0;i<list1.size();i++){
         for(int j=index; j<list2.size(); j++ ) {
             if(list1.get(i).equals(list2.get(j))) {
                 count++;
                 index = j+1;
                 break;
             }
         }
      }
    System.out.println(count); 
      return count;
    }
}