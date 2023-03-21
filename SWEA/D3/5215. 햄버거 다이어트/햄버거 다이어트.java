import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] cal, score;
    static int ans;
    static int N, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
             
            cal = new int[N];
            score = new int[N];
             
            for(int i=0;i<N;i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st1.nextToken());
            cal[i] = Integer.parseInt(st1.nextToken());
            }
            ans = 0;
            go(0,0,0);
            System.out.println("#"+tc+" "+ans);
        }
    }
    private static void go(int sumcal, int sumscore, int idx) {
        if(sumcal > L) return;
        if(idx >= N) {
            if(sumcal <= L && sumscore > ans ) {
                ans = sumscore;
            }
            return;
        } else {
            go(sumcal+cal[idx],sumscore+score[idx] ,idx+1);
            go(sumcal,sumscore,idx+1);
 
}
}
    }