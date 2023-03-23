import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,B,result;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		result= Integer.MAX_VALUE;
		arr = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		height(0,0);
		System.out.println("#"+tc+" "+result);
	}}
	
	public static void height(int idx, int sum) {
		if(idx == N) {
			if(sum >= B) {
				int num = Math.abs(sum-B);
				if(num < result) result = num;
			}
			return;
		}
		
		height(idx+1, sum+arr[idx]);
		height(idx+1, sum);
	}

}