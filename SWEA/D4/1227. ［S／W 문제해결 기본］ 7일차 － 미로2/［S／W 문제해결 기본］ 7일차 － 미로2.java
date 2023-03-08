import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] arr;
	static int N,startrow,startcol;
	static int[] dr = { -1, 0, 1, 0};
    static int[] dc = {  0, 1, 0, -1};
	static boolean found;
	public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			int T = Integer.parseInt(br.readLine());
			N = 100;
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j] = s.charAt(j)-'0';
					if(arr[i][j] == 2) {
						startrow = i;
						startcol = j;
					}
				}
			}
			found = false;

			boolean[][] visited = new boolean[N][N];
			search(startrow,startcol,visited);
			if(found) System.out.println("#"+T+" "+1);
			else System.out.println("#"+T+" "+0);
		}
	}
	private static void search(int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		
		if(found == false ) {
		for(int k=0;k<4;k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if((arr[nr][nc] == 0 || arr[nr][nc] ==3) && visited[nr][nc] == false ) {
					if(arr[nr][nc] == 3 ) found = true;
					search(nr,nc,visited);
					visited[nr][nc] = false;
				}
			}
		}
		
		}
	}

}