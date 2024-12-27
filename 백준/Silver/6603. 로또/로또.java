import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr,ans;
    static boolean[] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if(N == 0) break;

            arr = new int[N];
            ans = new int[N];
            visited = new boolean[N];

            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

            rec(0,0);

            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void rec(int start, int depth) {
        if(depth == 6) {
            for(int i=0;i<depth;i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=start;i<N;i++) {
            ans[depth] = arr[i];
            if(!visited[i]) {
                visited[i] = true;
                rec(i,depth+1);
                visited[i] = false;
            }
        }
    }
}