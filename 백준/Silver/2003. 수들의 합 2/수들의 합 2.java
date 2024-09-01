
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0 ,e = 0;
        int total = arr[0];

        while(e<N) {
            if(total<M) {
                total += arr[++e];
            } else if (total>M) {
                total -= arr[s++];
            } else {
                answer++;
                total -= arr[s++];
                total += arr[++e];
            }
        }

        System.out.println(answer);
    }
}