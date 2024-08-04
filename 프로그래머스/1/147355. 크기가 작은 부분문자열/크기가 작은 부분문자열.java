class Solution {
    public int solution(String t, String p) {
        int len = p.length();
        int answer = 0;
        long pInt = Long.parseLong(p);
        
        for(int i=0;i<t.length()-len + 1;i++) {
            long diff = Long.parseLong(t.substring(i,i+len));
            if(diff<=pInt) answer++;
        }
        return answer;
    }
}
