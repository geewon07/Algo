
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int s = 0;
        int e = n-1;
        int resMin = Math.abs(arr[0]+arr[n-1]);
        int min1 = arr[0];
        int min2 = arr[n-1];

        while(s<e) {
            int res = arr[s] + arr[e];
            if(Math.abs(res) < resMin) {
                resMin = Math.abs(res);
                min1 = arr[s];
                min2 = arr[e];
            }
            if(res == 0) break;
            if(res>0) e--;
            else s++;
        }


        System.out.println(min1+" "+min2);
    }
}