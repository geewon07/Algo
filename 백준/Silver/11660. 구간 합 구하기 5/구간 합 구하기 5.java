import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n+2][n+2];

        for(int i=1;i<n+1;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++) {
              board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sumBoard = new int[n+2][n+2];
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                sumBoard[i][j] = sumBoard[i-1][j]+sumBoard[i][j-1]-sumBoard[i-1][j-1]+board[i][j];
            }
        }

        for(int k=0;k<m;k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = sumBoard[x2][y2]-sumBoard[x2][y1-1]-sumBoard[x1-1][y2] + sumBoard[x1-1][y1-1];
            sb.append(ans+"\n");
        }
        System.out.println(sb);

    }

}