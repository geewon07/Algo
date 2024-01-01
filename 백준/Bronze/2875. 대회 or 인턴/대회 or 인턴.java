import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0 ;

        for(int i=0;i<=K;i++) {
            int fel = N - i;
            int male = M - (K - i);

            int ans = Math.min(fel/2,male);

            answer = Math.max(ans,answer);
        }
        System.out.println(answer);
    }
}