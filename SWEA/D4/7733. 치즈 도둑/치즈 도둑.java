import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution {
	static int N,max,result;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = 1;
        max = 0;
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(max<arr[i][j]) max = arr[i][j];
        		if(arr[i][j] == 1) arr[i][j] = 0;
        	}
        }
        
        cheese(1);
        System.out.println("#"+tc+" "+result);
	}
	}
	private static void cheese(int idx) {
		int count = 0;

        visited = new boolean[N][N];
        
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && arr[i][j] != 0 ) {
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] { i, j });
					visited[i][j] = true;
					count++;
					while(!q.isEmpty()) {
						int[] nums = q.poll();
						int r = nums[0];
						int c = nums[1];
						for(int k=0;k<4;k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if(nr>=0 && nr<N && nc>=0 && nc<N && arr[nr][nc] != 0 && !visited[nr][nc]) {
								visited[nr][nc] = true;
								q.add(new int[] {nr,nc});
							}
						}
					}
				}
			}
		}
		
		if(count > result ) result = count;
		

		if(idx == max) return;
		
		for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		if(arr[i][j] == idx+1 ) arr[i][j] = 0;
        	}
        }
		cheese(idx+1);
		
	}
    	
    }