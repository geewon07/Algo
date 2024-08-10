class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int remainder = 0;
        while(n >= a) {
            remainder += (n % a);
            n = (n / a) * b;
            answer += n;
            if(n < a) {
                n += remainder;
                remainder = 0;
            }
        }
        return answer;
    }
}