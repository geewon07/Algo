class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String s = String.valueOf(x);
        int total = 0;
        for(int i=0;i<s.length();i++) {
            total += s.charAt(i) - '0';
        }
        answer = x % total == 0 ? true : false;
        return answer;
    }
}