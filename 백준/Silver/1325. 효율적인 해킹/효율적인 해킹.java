import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.text.html.StyleSheet.ListPainter;

public class Main {
	static int[] p ;
	static boolean[] visited;
	static int[] dp;
	static int N, count,result;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] results;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	for(int i=0;i<N+1;i++) {
    		list.add(new ArrayList<>());
    	}
    	
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		list.get(b).add(a);
    	}
    	results = new int[N+1];
    	
    	for(int i=1;i<N+1;i++) {
        	visited = new boolean[N+1];
            count = 0;
			bfs(i);
    		results[i] = count;
    		result = Math.max(result, count);
    	}
    	for(int i=1;i<N+1;i++) {
    		if(results[i] == result ) sb.append(i).append(" ");
    	}
    	System.out.println(sb);
    }
	private static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
        visited[idx] = true;
        
        while(!q.isEmpty()) {
        	int num = q.poll();
        	
        	for(int i : list.get(num)) {
        		if(!visited[i]) {
        			q.add(i);
        			visited[i] = true;
        			count++;
        		}
        	}
        }
	}
    
    }