import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class move {
		int x,y,kcnt,cnt;
        public move(int x, int y, int kcnt, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.kcnt = kcnt;
			this.cnt = cnt;
		}
	}
	static int K,W,H,result;
	static int dx[]= {0,0,1,-1};
    static int dy[]= {1,-1,0,0};
    static int k_dx[] = {-2,-1,1,2,-2,-1,1,2};
    static int k_dy[] = {-2,-2,-2,-1,1,2,2,1};
	static int[][] map;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	K = Integer.parseInt(br.readLine());
	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	W = Integer.parseInt(st.nextToken());
	H = Integer.parseInt(st.nextToken());
	
	map = new int[H][W];
	
	for(int i=0;i<H;i++) {
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int j=0;j<W;j++) {
			map[i][j] = Integer.parseInt(st1.nextToken());
		}
	}
	visited = new boolean[H][W][K+1];
	result = Integer.MAX_VALUE;
	bfs();
	if(result == Integer.MAX_VALUE) System.out.println(-1);
	else System.out.println(result);
	
}
	static void bfs() {
		Queue<move> q = new LinkedList<>();
		q.add(new move(0,0,0,0));
		visited[0][0][0] = true ;
		
		while(!q.isEmpty()) {
			move m = q.poll();
			int x = m.x;
			int y = m.y;
			int kcnt = m.kcnt;
			int cnt = m.cnt;
			
			if(x==H-1 && y==W-1) {
				result = Math.min(cnt, result);
			}
			for(int i=0;i<4;i++) {
				int nr = x + dx[i];
				int nc = y + dy[i];
				
				if(check(nr,nc) && !visited[nr][nc][kcnt] && map[nr][nc] == 0) {
					visited[nr][nc][kcnt] = true;
					q.add(new move(nr,nc,kcnt,cnt+1));
				}
			}
			
			if(kcnt >= K) continue;
			
				for(int i=0;i<8;i++) {
					int nr = x + k_dx[i];
					int nc = y + k_dy[i];
					
					if(check(nr,nc) && !visited[nr][nc][kcnt+1] && map[nr][nc] == 0) {
						visited[nr][nc][kcnt+1] = true;
						q.add(new move(nr,nc,kcnt+1,cnt+1));
					}
				}
		}
	}
	
	static boolean check(int nr, int nc) {
		return nr >= 0 && nr < H && nc>=0 && nc<W;
	}
}