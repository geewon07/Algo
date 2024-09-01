
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long answer = 0;

        Map<Integer,Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        int[] prefix_sum = new int[N+1];

        for(int i=1;i<N+1;i++) {
            prefix_sum[i] = prefix_sum[i-1] + Integer.parseInt(st.nextToken());
        }

        map.put(0,1);

        for(int i=1;i<N+1;i++) {
            if(map.containsKey(prefix_sum[i] - K)) {
                answer += map.get(prefix_sum[i]-K); // map.getOrDefault(sum[i]-K,0);
            }
            map.put(prefix_sum[i],map.getOrDefault(prefix_sum[i],0)+1);
        }
        System.out.println(answer);
    }
}