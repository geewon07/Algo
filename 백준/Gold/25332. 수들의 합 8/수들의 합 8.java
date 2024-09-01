
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long answer = 0;

        Map<Integer,Integer> map = new HashMap<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] prefix_Asum = new int[N+1];
        int[] prefix_Bsum = new int[N+1];

        for(int i=1;i<N+1;i++) {
            prefix_Asum[i] = prefix_Asum[i-1] + Integer.parseInt(st1.nextToken());
            prefix_Bsum[i] = prefix_Bsum[i-1] + Integer.parseInt(st2.nextToken());

            if(prefix_Asum[i] == prefix_Bsum[i]) answer++;

            answer += map.getOrDefault(prefix_Asum[i]-prefix_Bsum[i],0);

            map.put(prefix_Asum[i]-prefix_Bsum[i],map.getOrDefault(prefix_Asum[i]-prefix_Bsum[i],0)+1);
        }
        System.out.println(answer);
    }
}