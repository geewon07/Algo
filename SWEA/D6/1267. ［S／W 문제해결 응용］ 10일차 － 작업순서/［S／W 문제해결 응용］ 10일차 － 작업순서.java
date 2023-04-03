import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=10;tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[V+1];
			int[][] map = new int[V+1][V+1];
			

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++) {
					int a = Integer.parseInt(st1.nextToken());
					int b = Integer.parseInt(st1.nextToken());
					
					map[a][b] = 1;
					arr[b]++;
			}
			Queue<Integer> q = new LinkedList<>();
			
			for(int i=1;i<V+1;i++) {
				if(arr[i] == 0) {
					q.add(i);
				sb.append(i).append(" ");
				}
			}
			
			while(!q.isEmpty()) {
				int num = q.poll();
				for(int i=1;i<V+1;i++) {
					if(map[num][i] == 1) {
						arr[i] -= 1;
						if(arr[i] == 0) {
							q.add(i);
							sb.append(i).append(" ");
						}
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}