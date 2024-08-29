
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] xstar = new int[K];
        int[] ystar = new int[K];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xstar[i] = x;
            ystar[i] = y;
        }

        int answer = 0;
        for(int i=0;i<K;i++) {
            for(int j=0;j<K;j++) {
                int count = 0;
                int x = xstar[i];
                int y = ystar[j];

                for(int k=0;k<K;k++) {
                    if(xstar[k] >= x && xstar[k] <= x+L && ystar[k] >= y && ystar[k] <= y+L) count++;
                }
                answer = Math.max(answer, count);
                if(answer == K) {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(K-answer);
    }
}