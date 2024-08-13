class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int cnt = section[0];
        for(int i=1;i<section.length;i++) {
            if(cnt + m -1 < section[i]) {
                answer++;
                cnt = section[i];
            }
        }
        return answer;
    }
}