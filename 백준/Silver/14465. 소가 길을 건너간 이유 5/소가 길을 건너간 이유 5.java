
import java.util.*;
import java.io.*;

public class Main {
    // 투포인터
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+2];

        for(int i=0;i<b;i++) {
            arr[Integer.parseInt(br.readLine())] = 1;
        }

        int answer = Integer.MAX_VALUE;
        int s = 1;
        int e = 1;
        int cnt = arr[e];

        while(s<=e && e<n+1) {
            int len = (e+1) - s;
            if(len == k) {
                answer = Math.min(answer,cnt);
                if(arr[s++] == 1) cnt--;
            }
            if(arr[++e] == 1) cnt++;
        }

        System.out.println(answer);
    }
}