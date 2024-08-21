class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] answers = new int[3];
        
        int i = 0;
        int nowValue = 0;
        int count = 0;
        
        while(i<dartResult.length()) {
            char s = dartResult.charAt(i);
            if(s-'0'>=0 && s-'0'<=9) {
                if(dartResult.charAt(i+1) -'0' >=0 && dartResult.charAt(i+1)-'0'<=9) {
                    nowValue = 10;
                    i += 2;
                }else {
                  nowValue = s - '0';
                  i++;  
                } 
                s = dartResult.charAt(i);
                if(s == 'D') nowValue = (int)Math.pow(nowValue,2);
                if(s == 'T') nowValue = (int) Math.pow(nowValue,3);
                i++;
                if(i<dartResult.length() && (dartResult.charAt(i)-'0'< 0 || (dartResult.charAt(i))-'0'>9)) {
                    s = dartResult.charAt(i);
                    if(s == '*') {
                        nowValue *= 2;
                        if(count>0) answers[count-1] *= 2;
                        i++;
                    } else if(s == '#') {
                        nowValue = -nowValue;
                        i++;
                    }
                    
                }
                answers[count] = nowValue;
                count++;
            }
        }
        
        for(int j=0;j<3;j++) {
            answer += answers[j];
        }
        return answer;
    }
}