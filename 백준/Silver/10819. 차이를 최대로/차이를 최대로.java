import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int ans;
    static boolean[] visited;
    static int[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N];
        selected = new int[N];
        ans = Integer.MIN_VALUE;
        rec(0);
        System.out.println(ans);
    }

    static void rec(int depth) {
        if(depth == N) {
            int sum = 0;
            for(int i=0;i<N-1;i++) {
                sum += Math.abs(selected[i] - selected[i+1]);
            }
            ans = Math.max(ans,sum);
            return;
        }
        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[depth] = arr[i];
                rec(depth+1);
                visited[i] = false;
            }
        }
    }
}