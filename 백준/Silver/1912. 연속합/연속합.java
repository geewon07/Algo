
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prefix_sum = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = Integer.MIN_VALUE;

        for(int i=1;i<n+1;i++) {
            int now = Integer.parseInt(st.nextToken());
            prefix_sum[i] = Math.max(prefix_sum[i-1]+now,now);
            answer = Math.max(answer, prefix_sum[i]);
        }
        System.out.println(answer);
    }
}