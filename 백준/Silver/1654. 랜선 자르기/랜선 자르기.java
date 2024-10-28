import java.io.*;
import java.util.*;


public class Main {
    static int K,N;
    static int max = 0;
    static int[] arr;
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        // 이분탐색 => 랜선의 최대 길이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];

        for(int i=0;i<K;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,arr[i]);
        }

        binarySearch(1,max);

        System.out.println(answer);

    }
    static void binarySearch(long s,long e) {
        long mid;
        int cnt;
        while (s <= e) {
            mid = (s + e) / 2;

            cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += arr[i] / (int)mid;
            }

            if (cnt >= N) {
                answer = Math.max(answer, mid);
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
    }
}