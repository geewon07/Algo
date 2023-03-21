import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int K;
	static int[] arr;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st1.nextToken());
			}
			count = 0;
			search(0,0);
			System.out.println("#"+tc+" "+count);
			
		}
		
	}
	static void search(int idx, int sum) {
		if(sum == K ) {
			count++;
			return;
		}
		if(idx == N) {
			return;
		}
		
		search(idx+1, sum+arr[idx]);
		search(idx+1,sum);
		
	}
	

}