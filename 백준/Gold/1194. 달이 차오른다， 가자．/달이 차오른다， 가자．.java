import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class node {
		int x,y,cnt,key;
		public node(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}
	static int N,M,ans;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0};
	static int[] dc = {  0, 0, -1, 1};
	static boolean[][][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int sx = 0, sy= 0;
		 for (int i = 0; i < N; i++) {
	            String s = br.readLine();
	            for (int j = 0; j < M; j++) {
	            	map[i][j] = s.charAt(j);
	                if (map[i][j] == '0') {
	                    sx = i;
	                    sy = j;
	                }
	            }
	     }
		 
		visited = new boolean[N][M][64];
		
		ans = -1;
		visited[sx][sy][0] = true;
		bfs(sx,sy);
		System.out.println(ans);
}
	
	private static void bfs(int i, int j) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(i,j,0,0));
		
		while(!q.isEmpty()) {
			node n = q.poll();
			
			for(int k=0;k<4;k++) {
				int nr = n.x + dr[k];
				int nc = n.y + dc[k];
				
				if(check(nr,nc) && map[nr][nc] != '#' && !visited[nr][nc][n.key]) {
					if(map[nr][nc] == '1' ) { // 출구라면
						ans = n.cnt + 1;
						return;
					} else if (map[nr][nc] == '.' | map[nr][nc] == '0') {
						visited[nr][nc][n.key] = true;
						q.add(new node(nr,nc,n.cnt+1,n.key));
					} else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						int num = 1 << (map[nr][nc]-'a');
							visited[nr][nc][n.key | num] = true;
							q.add(new node(nr,nc,n.cnt+1,n.key | num));
					} else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F'){
						int num = 1 << (map[nr][nc] - 'A');
						if((num & n.key) != 0) {
							visited[nr][nc][n.key] = true;
							q.add(new node(nr,nc,n.cnt+1,n.key));
						}
					}
				}
			}
		}
		
	}
	static boolean check(int r,int c) {
		return r>=0 && r< N && c>=0 && c< M;
	}
}