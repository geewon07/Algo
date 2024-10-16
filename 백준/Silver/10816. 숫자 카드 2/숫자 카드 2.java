import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(rightBound(num) - leftBound(num) + 1).append(" ");
        }

        System.out.println(sb);
    }

    public static int leftBound(int num) {
        int s = 0, e = N-1, l = 1;

        while(s <= e) {
            int mid = (s + e) / 2;

            if(arr[mid] > num) e = mid -1;
            else if(arr[mid] < num) s = mid + 1;
            else {
                l = mid;
                e = mid - 1;
            }
        }
        return l;
    }

    public static int rightBound(int num) {
        int s = 0, e = N-1, r = 0;

        while(s <= e) {
            int mid = (s + e) / 2;

            if(arr[mid] > num) e = mid -1;
            else if(arr[mid] < num) s = mid + 1;
            else {
                r = mid;
                s = mid + 1;
            }
        }
        return r;
    }
}
