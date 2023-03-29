import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // n이하의 자연수
			int m = Integer.parseInt(st.nextToken()); // m개의 연산
			
			p = new int[n+1];
			
			for(int i=0;i<n+1;i++) {
				p[i] = i;
			}
			
			for(int i=0;i<m;i++) {
				StringTokenizer	st1 = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st1.nextToken());
				int a = Integer.parseInt(st1.nextToken());
				int b = Integer.parseInt(st1.nextToken());
				if(k==0) {
					union(a,b);
				} else if(k==1) {
					if(find(a) == find(b)) {
						sb.append(1);
					}else 
						sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		}
	private static int find(int a) {
		if(a==p[a]) return a;
		else {
			return p[a] = find(p[a]);
		}
	}
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb ) return;
		p[pb] = pa;
		
	}
	}