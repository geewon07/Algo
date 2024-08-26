import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] arr = new int[h+1];

        for(int i=0;i<n;i++) {
            int x = Integer.parseInt(br.readLine());
            if(i%2 == 0) {
                arr[0] += 1;
                arr[x] -= 1;
            }else {
                arr[h-x] += 1;
                arr[h] -= 1;
            }
        }

        int[] sumArr = new int[h+1];
        sumArr[0] = arr[0];
        for(int i=1;i<h+1;i++) {
            sumArr[i] = sumArr[i-1]+arr[i];
        }

        int min = n;
        int cnt = 0;

        for(int i=0;i<h;i++) {
            if(min>sumArr[i]) {
                min = sumArr[i];
                cnt = 0;
            }
            if(min == sumArr[i]) cnt++;
        }

        System.out.println(min+" "+cnt);

    }

}