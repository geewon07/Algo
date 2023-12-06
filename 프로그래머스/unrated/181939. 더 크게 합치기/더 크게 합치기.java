class Solution {
    public int solution(int a, int b) {
        String a1 = String.valueOf(a) + String.valueOf(b);
        String b1 = String.valueOf(b) + String.valueOf(a);
        int answer = 0;
        if(Integer.parseInt(a1) >= Integer.parseInt(b1)) {
            answer = Integer.parseInt(a1);
        }else {
            answer = Integer.parseInt(b1);
        }
        
        return answer;
    }
}