import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,M,ans,count;
	static int[][] map;
	static int[] arr;
//	static List<Integer> list;
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	StringTokenizer st;
	int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N+1][N+1];
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[a][b] = 1;
				map[b][a] = 1;
			}
			count = 1;
			arr = new int[N+1];
			search(1,0);
			sb.append(count).append("\n");
			
		}	
		System.out.println(sb);
	}
	 static void search(int idx, int cnt) {
		 if(idx == N+1) {
	           return;
	     }
		 boolean check = false;
		 for(int i=0;i<cnt;i++) {
			if(map[arr[i]][idx] == 1 | map[idx][arr[i]] == 1) {
				check = true;
				break;
			}
		 }
		 
		 if(!check) {
			 count++;
			 arr[cnt] = idx;
			 search(idx+1,cnt+1);
			 arr[cnt] = 0;
		 }
		 
		 search(idx+1,cnt);
		 
	 
	 
	 }
	
}