import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int[] dis;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=10;tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			list = new ArrayList[101];
			
			for(int i=0;i<101;i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N/2;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
			}
			
			dis = new int[101];
			visited = new boolean[101];
			
			dis[start] = 0;
			
			dijkstra(start);
			
			int result = 0;
			int idx = 0;
			for(int i=0;i<dis.length;i++) {
				if(dis[i] >= result) {
					result = dis[i];
					idx = i;
				}
			}
		sb.append(idx);
		sb.append("\n");
		
		}
		System.out.println(sb);
		
	}
	private static void dijkstra(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			for(int i : list[x]) {
				if(!visited[i]) {
					dis[i] = dis[x] + 1;
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}