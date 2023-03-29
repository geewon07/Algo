import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {
    static int[] money, month;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            money = new int[3];
            for(int i=0;i<3;i++) {
                money[i] = Integer.parseInt(st.nextToken()); 
            }
            result = Integer.parseInt(st.nextToken()); // 아예 처음 result 값에다 1년 이용권을 넣어줌
             
            // idx => 0 : 1일 이용권 1: 1달 이용권 2: 3달 이용권
            month = new int[12];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int i=0;i<12;i++) {
                month[i] = Integer.parseInt(st1.nextToken());
            }
             
            cal(0,0,0,0);
            System.out.println("#"+tc+" "+result);
             
             
     
    }
    }
    static void cal(int idx, int amount,int three, int cnt) {
         
        if(amount >= result) return;
         
        if(idx == 12) {
            if(amount < result ) result = amount;
            return;
        }
         
        if(month[idx] == 0) {
            if(three == 1 && cnt < 3) {
                cal(idx+1,amount,1, cnt+1);
            } else {
                cal(idx+1,amount,0,0);
            }
        } else {
        if(three == 1 && cnt < 3) {
            cal(idx+1,amount,1,cnt+1);
        } else {
             
            // 1일 이용권을 선택했을 경우
            int how = month[idx] * money[0];
            cal(idx+1,amount+how,0,0);
             
            // 1달 이용권을 선택했을 경우
            how = money[1];
            cal(idx+1,amount+how,0,0);
             
            // 3달 이용권을 선택했을 경우
            how = money[2];
            cal(idx+1,amount+how,1,1);
        }
    }
    }
}