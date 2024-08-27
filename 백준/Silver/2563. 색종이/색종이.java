
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] board = new int[100][100];

        int answer = 0;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int a = x; a < x + 10; a++) {
                for (int b = y; b < y + 10; b++) {
                    board[a][b] = 1;
                }
            }
        }

            for(int i=0;i<100;i++) {
                for(int j=0;j<100;j++) {
                    if(board[i][j] == 1) answer++;
                }
            }





        System.out.println(answer);
    }
}