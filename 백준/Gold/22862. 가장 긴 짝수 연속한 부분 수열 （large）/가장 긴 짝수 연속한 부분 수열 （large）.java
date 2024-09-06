
import java.util.*;
import java.io.*;

public class Main {
    // 투포인터
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int answer = 0;
        int cnt = 0;

        while(s<=e && e<n) {
            if(cnt > k) {
                if(arr[s] % 2 == 1) cnt --;
                s++;
            }else {
                if(arr[e] %2 == 1) cnt++;
                e++;
            }
            answer = Math.max(answer, e-s-cnt);
        }

        System.out.println(answer);
    }
}