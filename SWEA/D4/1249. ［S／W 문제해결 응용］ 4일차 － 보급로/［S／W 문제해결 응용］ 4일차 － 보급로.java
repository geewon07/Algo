import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] arr;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1};
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[0][0] = 0;
//		for(int i=0;i<N;i++) {
//			Arrays.fill(dp[i], Integer.MAX_VALUE);
//		}
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		bfs(0,0);
		System.out.println("#"+tc+" "+dp[N-1][N-1]);
		}
	}
	static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[]{i,j});
		
		while(!q.isEmpty()) {
			int[] num = q.poll();
			int r = num[0];
			int c = num[1];
			
			for(int k=0;k<4;k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(dp[nr][nc]>dp[r][c]+arr[nr][nc]) {
						dp[nr][nc] = dp[r][c]+arr[nr][nc];
						q.add(new int[] {nr, nc});
					}
				}
			}
		}
	}
}