import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long s = 0;
        long e = N * N;
        long ans = 0;

        while(s <= e){
            long mid = (s + e) / 2;
            long count = 0;

            for(long i = 1; i<=N; i++){
                count += Math.min(mid / i, N);
            }

            if(count < K) s = mid + 1;
            else {
                e = mid - 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}
