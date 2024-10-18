import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        long[] arr = new long[N];

        // 투포인터 : s, e 합한 값이 x/2 이상이면 하나의 용기가 만들어짐!

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr); // 투포인터는 정렬 필수

        long min = X%2 == 0 ? X/2 : X/2 + 1;

        int s = 0, e = N-1;
        int ans = 0;
        int remain = 0;

        while(s<=e) {
            if(arr[e] == X) {
                ans++;
                e--;
                continue;
            }
            long sum = arr[s] + arr[e];
            if( s<e && sum >= min ) {
                ans ++;
                s++;
                e--;
            }else {
                remain++;
                s++;
            }
        }

        ans += remain/3;

        System.out.println(ans);



    }
}
