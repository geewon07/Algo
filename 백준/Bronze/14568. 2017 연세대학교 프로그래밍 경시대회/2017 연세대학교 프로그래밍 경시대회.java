import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0 ;

        for(int i=1;i<N/2;i++) {
            int count = 2;
            while(count+i<=N-1) {
                int b = N - i - (i+count);
                if(b >= 1 && b %2 == 0) {
                    answer++;
                }
                count++;
            }
        }
        System.out.println(answer);
    }
}