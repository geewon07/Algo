
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++) {
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }
        for(int i=k;i<=n;i++){
            int rangeSum = arr[i] - arr[i-k];
            max = Math.max(max, rangeSum);
        }
        System.out.println(max);
    }
}