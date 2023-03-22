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
	static int N, M, V;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N+1];
			
			for(int i=0;i<N+1;i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0;i<M;i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st1.nextToken());
				int n2 = Integer.parseInt(st1.nextToken());
				
				graph[n1].add(n2);
				graph[n2].add(n1);
			}
			for(int i=1;i<N+1;i++) {
				Collections.sort(graph[i]);;
			}
			
			visited = new boolean[N+1];
		    dfs(V);	
		    System.out.println();
		    visited = new boolean[N+1];
		    bfs(V);
		}
	
	private static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(idx);
		visited[idx] = true;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			System.out.print(n+" ");
			
			for(int x : graph[n]) {
				if(!visited[x]) {
					q.add(x);
					visited[x] = true;
				}
			}
		}
		
		
	}

	private static void dfs(int idx) {
		System.out.print(idx+" ");
		
		visited[idx] = true;
		
		for(int i=0;i<graph[idx].size();i++) {
			if(!(visited[graph[idx].get(i)])) {
				dfs(graph[idx].get(i));
			}
		}
		
		
	}
}