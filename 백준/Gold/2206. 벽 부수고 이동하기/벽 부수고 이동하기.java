import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class move {
		int x, y, cnt, wallbomb;

		public move(int x, int y, int cnt, int wallbomb) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wallbomb = wallbomb;
		}
	}
	static int[][] map;
	static int N,M,result;
	static boolean[][][] visited;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[2][N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		result = Integer.MAX_VALUE;
		bfs();
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	static void bfs() {
		Queue<move> q = new LinkedList<>();
		
		q.add(new move(0,0,1,0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			move nums = q.poll();
			int x = nums.x;
			int y = nums.y;
			int cnt = nums.cnt;
			int wallbomb = nums.wallbomb;
			
			if( x == N-1 && y == M-1) {
				result = Math.min(cnt, result);
			}
			
			for(int i=0;i<4;i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
				
				if(check(nr,nc) && map[nr][nc] == 0 && !visited[wallbomb][nr][nc]) {
					q.add(new move(nr,nc,cnt+1,wallbomb));
					visited[wallbomb][nr][nc] = true;
				}
			}
			if(wallbomb == 1) continue;
			
			for(int i=0;i<4;i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
				
				if(check(nr,nc) && map[nr][nc] == 1 && !visited[wallbomb+1][nr][nc]) {
					q.add(new move(nr,nc,cnt+1,wallbomb+1));
					visited[wallbomb+1][nr][nc] = true;
				}
			}
		}
		
	}
	static boolean check(int r,int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}