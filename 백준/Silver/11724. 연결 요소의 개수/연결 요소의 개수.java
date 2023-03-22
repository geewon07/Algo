import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static int N, M;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N+1];
			
			for(int i=0;i<N+1;i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0;i<M;i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());{
					int x = Integer.parseInt(st1.nextToken());
					int y = Integer.parseInt(st1.nextToken());
					graph[x].add(y);
					graph[y].add(x);
				}
			}
			visited = new boolean[N+1];
			int count = 0;
			for(int i=1;i<N+1;i++) {
				if(!visited[i]) {
					dfs(i);
					count++;
				}
			}
			System.out.println(count);
		}
	private static void dfs(int idx) {
		if(visited[idx]) {
			return;
		}else {
			visited[idx] = true;
			for(int i=0;i<graph[idx].size();i++) {
				dfs(graph[idx].get(i));
			}
		}
	}	
      
	  
}