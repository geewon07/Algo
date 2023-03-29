import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1];
			
			for(int i=0;i<N+1;i++) {
				p[i] = i;
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			Set<Integer> arr = new HashSet<>();
			
			for(int i=1;i<N+1;i++) {
					arr.add(find(i));				
			}
			System.out.println("#"+tc+" "+arr.size());
			}
		}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		p[pb] = pa;
	}
	
	static int find(int x) {
		if(x == p[x]) 
			return x;
		else {
			return p[x] = find(p[x]);
		}
		
	}
	}