import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        // M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값!

        int s = 0;
        int e = max;
        int ans = 0;

        while(s<=e) {
            int mid = (s+e)/2;
            long sum = 0;

            for(int i=0;i<N;i++) {
                if(arr[i] > mid) sum += arr[i] - mid;
            }

            if(sum < M) e = mid - 1;
            else {
                s = mid + 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}
