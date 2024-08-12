
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [] answer = new int[N];
        int[][] location = new int[N][2];

        for(int i=0;i<N;i++) {
            answer[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            location[i][0] = Integer.parseInt(st.nextToken());
            location[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                int curx = location[i][0];
                int cury = location[j][1];

                int[] dist = new int[N];
                for(int k=0;k<N;k++) {
                    dist[k] = Math.abs(curx - location[k][0]) + Math.abs(cury - location[k][1]);
                }
                Arrays.sort(dist);
                int value = 0;
                for(int k=0;k<N;k++) {
                    value += dist[k];
                    answer[k] = Math.min(value, answer[k]);
                }
            }
        }


        for(int k = 0; k < N; k++){
            System.out.print(answer[k] + " ");
        }
    }
}