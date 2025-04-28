import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
        }

        int[] leftMax = new int[1002];
        int[] rightMax = new int[1002];

        for(int i=1;i<1001;i++) {
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }
        for(int i=1000;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1],arr[i]);
        }

        int answer = 0;

        for(int i=1;i<1001;i++ ) {
            answer += Math.min(rightMax[i],leftMax[i]);
        }

        System.out.println(answer);

    }

}