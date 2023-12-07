class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for(int i=0;i<code.length();i++) {
            char s = code.charAt(i);
            
            if(s=='1') {
                if(mode == 0) {
                    mode = 1;
                }else {
                    mode = 0;
                }
            } else {
                if(mode == 0 && i % 2 == 0) {
                    answer += s;
                } else if ( mode == 1 && i % 2 == 1) {
                    answer += s;
                }
            }
        }
        
        if(answer.length() == 0) answer = "EMPTY";
            
        return answer;
    }
}