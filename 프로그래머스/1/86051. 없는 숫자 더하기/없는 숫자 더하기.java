class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] found = new boolean[10];
        for(int i=0;i<numbers.length;i++) {
            found[numbers[i]] = true;
        }
        for(int i=0;i<10;i++) {
            if(!(found[i])) answer += i;
        }
        return answer;
    }
}