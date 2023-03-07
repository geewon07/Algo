import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { 0 , 1, 0, -1 }; 
    static int[] dc = { 1 , 0, -1, 0 };
	static boolean find = false;
	static int[][] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=10;tc++) {
			int T = Integer.parseInt(br.readLine());
			N = 16;
			arr = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j] = s.charAt(j)-'0';
				}
			}
			
			find = false;
			dfs(1,1,visited);
			if(find) System.out.println("#"+T+" "+1);
			else System.out.println("#"+T+" "+0);
			}
	}

	private static void dfs(int i, int j, boolean[][] visited) {
	    visited[i][j] = true;
		
		if(find == false ) {
			for(int k=0;k<4;k++) {
				int nr = i + dr[k];
				int nc = j + dc[k];
				
				if(nr>=0 && nr<N && nc>=0 && nc < N) {
					if((arr[nr][nc] == 0 | arr[nr][nc] == 3) && visited[nr][nc] == false) {
						if(arr[nr][nc] == 3) find = true; 
						dfs(nr, nc, visited); 
						visited[nr][nc] = false;
					}
				}
			}
		}
	
	}
	

}