
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());
        int s = 0;
        int e = n-1;

        while(s<e) {
            if(arr[s]+arr[e] == x) {
                answer++;
                s++;
                e--;
            }else if(arr[s]+arr[e] > x) {
                e--;
            }else {
                s++;
            }
        }
        System.out.println(answer);
    }
}