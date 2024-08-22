
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][2];
        int[] time = new int[1001];

        int total = 0;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            for(int j=arr[i][0];j<arr[i][1];j++) {
                if(time[j] == 0) {
                    total++;
                }
                time[j]++;
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=arr[i][0];j<arr[i][1];j++){
                if(time[j]<=1) {
                    count++;
                }
            }
            answer = Math.min(answer,count);
        }
        System.out.println(total-answer);
    }
}