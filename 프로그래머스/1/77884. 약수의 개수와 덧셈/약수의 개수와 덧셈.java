class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++) {
         // 제곱수인 경우 => 약수의 개수 홀수 // Math.sqrt => 기본적으로 double형 (int형을 써도 에러는 안남)
            if(i % Math.sqrt(i) == 0 ) {
                answer -= i;
            }else {
                answer +=i;
            }
        }
        return answer;
    }
}
