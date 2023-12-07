class Solution {
    public int solution(int a, int b) {
        String a1 = String.valueOf(a) + String.valueOf(b);
        int b1 = 2 * a * b;
        int answer = Math.max(b1, Integer.parseInt(a1));
        return answer;
    }
}