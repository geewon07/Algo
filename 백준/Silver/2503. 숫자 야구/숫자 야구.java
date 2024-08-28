
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<baseball> info = new ArrayList<>();

    static class baseball{
        int strike,ball;
        String num;
        public baseball(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int count = 0;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info.add(new baseball(num,s,b));
        }

        for(int i=123;i<=987;i++) {
            String ans = String.valueOf(i);

            if(ans.charAt(0) == '0' || ans.charAt(1) == '0' || ans.charAt(2) == '0') continue;
            if(ans.charAt(0) == ans.charAt(1) || ans.charAt(0) == ans.charAt(2) || ans.charAt(1) == ans.charAt(2)) continue;

            int check = 0;

            for(int j=0;j<n;j++) {
                int scount = 0;
                int bcount = 0;

                for(int k=0;k<3;k++) {
                    if(ans.charAt(k) == info.get(j).num.charAt(k)) {
                        scount++;
                    }
                }
                for(int a=0;a<3;a++) {
                    for(int b=0;b<3;b++) {
                        if(ans.charAt(a) == info.get(j).num.charAt(b)) {
                            if(a != b) bcount++;
                        }
                    }
                }
                if(scount == info.get(j).strike && bcount == info.get(j).ball) {
                    check++;
                }
            }
            if(check == n) count++;
        }

        System.out.println(count);
    }
}