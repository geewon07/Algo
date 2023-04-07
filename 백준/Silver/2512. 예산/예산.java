import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int result = 0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(result < arr[i]) result = arr[i];
		}
		long M = Long.parseLong(br.readLine());
		
		long left = 0;
		long right = result;
		long answer = 0;
		while(left <= right) {
			long mid = ( left + right ) /2 ;
			long ans = 0;
			for(int i=0;i<N;i++) {
				ans += Math.min(arr[i], mid);
			}
			if(ans > M ) right = mid - 1;
			else if (ans < M) {
				left = mid + 1;
				answer = mid;
			} else {
				answer = mid;
				break;
			}
		}
		System.out.println(answer);
	}	
}