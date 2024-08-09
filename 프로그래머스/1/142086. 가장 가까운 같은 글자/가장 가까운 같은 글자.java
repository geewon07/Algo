class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] check = new int[26];
        for(int i=0;i<check.length;i++) {
            check[i] = -1;
        }
        for(int i=0;i<s.length();i++) {
            int count = (int)(s.charAt(i) - 'a');
            if(check[count] == -1) {
                answer[i] = -1;
                check[count] = i;
            } else {
                answer[i] = i - check[count];
                check[count] = i;
            }
        }
        return answer;
    }
}