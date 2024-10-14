import java.io.*;
import java.util.*;
public class Main {
    static int[][][] sum;
    static int x1,x2,y1,y2;
    static int Q;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        sum = new int[11][N+1][N+1];
        StringTokenizer st;
        for(int i=1;i<N+1;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++) {
                int n = Integer.parseInt(st.nextToken());
                for(int k=1;k<=10;k++) {
                    sum[k][i][j] = sum[k][i - 1][j] + sum[k][i][j - 1] - sum[k][i - 1][j - 1];
                }
                sum[n][i][j]++;
            }
        }

        Q = Integer.parseInt(br.readLine());
        for(int q=0;q<Q;q++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            sb.append(countNumber(x1, y1, x2, y2)).append("\n");
        }
        System.out.println(sb);
    }

    private static int countNumber(int x1, int y1, int x2, int y2) {
        int count = 0;
        int value = 0;
        for(int k=1;k<=10;k++) {
            value = sum[k][x2][y2] - sum[k][x2][y1-1]-sum[k][x1-1][y2]+sum[k][x1-1][y1-1];

            if(value>0) count++;
        }
        return count;
    }
}
