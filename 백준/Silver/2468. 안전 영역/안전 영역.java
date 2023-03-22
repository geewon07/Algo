import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N, max, count, result;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0 , 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(max<arr[i][j]) max = arr[i][j];
			}
		}
		result = 1;
		for(int i=1;i<max;i++) {
			count = 0;
			visited = new boolean[N][N];
			bfs(i);
			if(count > result) result = count;
		}
		System.out.println(result);
	}
	// i : 장마철에 내리는 비의 양
	private static void bfs(int idx) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] > idx && !visited[i][j] ) {
					count++;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i, j});
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] num = q.poll();
						int x1 = num[0];
						int y1 = num[1];
						
						for(int r=0;r<4;r++) {
							int nr = x1 + dr[r];
							int nc = y1 + dc[r];
							
							if(nr>=0 && nr < N && nc >= 0 && nc <N && !visited[nr][nc] && arr[nr][nc] > idx) {
								q.add(new int[] {nr, nc} );
								visited[nr][nc] = true;
							}
						}
					}
					
				}
			}
		}
		
	}
}