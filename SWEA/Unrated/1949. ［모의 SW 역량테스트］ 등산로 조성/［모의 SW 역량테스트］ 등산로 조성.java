import java.io.*;
import java.util.*;;

public class Solution {
	static int N,K,max,maxcnt,ans;
	static int[] dr = { -1, 1, 0, 0};
	static int[] dc = {  0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	StringTokenizer st;
	int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			max = 0;
			maxcnt = 0;
			ans = 0;

			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(max < map[i][j]) { 
						max = map[i][j];
						maxcnt = 1;
					} else if(max == map[i][j]) maxcnt++;
				}
			}
			
loop:	for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == max) {
					visited[i][j] = true;
					dfs(i,j,1,0);
					visited[i][j] = false;
					maxcnt--;
					if(maxcnt == 0) break loop;
				}
			}
		}
	    sb.append(ans).append("\n");
    }
		System.out.println(sb);
	}
	
	
	static void dfs(int i, int j,int cnt,int kcnt) {
		for(int k=0;k<4;k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			
			if(check(nr,nc) && !visited[nr][nc]) {
				if(map[i][j] > map[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr,nc,cnt+1,kcnt);
					visited[nr][nc] = false;
				} else {
					if( kcnt == 0 ) {
						if( map[nr][nc] < map[i][j] + K ) {
							int num = map[nr][nc];
							map[nr][nc] = map[i][j] -1 ;
							visited[nr][nc] = true;
							dfs(nr,nc,cnt+1,kcnt+1);
							visited[nr][nc] = false;
							map[nr][nc] = num;
						} else {
							ans = Math.max(ans, cnt);
						}
					} else {
						ans = Math.max(ans, cnt);
					}
				}
			}
		}
		
	}
	static boolean check(int nr,int nc) {
		return nr >=0 && nr < N && nc>=0 && nc < N;
	}
}