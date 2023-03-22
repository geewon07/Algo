import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int half;
	static int[][] arr;
	static int count;
	static List<Integer> index1, index2;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			count = 0;
			half = N/2;
			min = Integer.MAX_VALUE;
			index1 = new ArrayList<Integer>();
			index2 = new ArrayList<Integer>();
			deli(0,0,index1,index2);
			System.out.println("#"+tc+" "+min);
		
		}	
	}
	static void deli(int idx, int count, List<Integer> index1, List<Integer> index2) {
		
		if(idx==N) {
			if(count == half) {
				int sum1 =0;
				int sum2 =0;
				for(int i=0;i<half;i++) {
					for(int j=0;j<half;j++) {
						if(i==j) continue;
							sum1 += arr[index1.get(i)][index1.get(j)];
							sum2 += arr[index2.get(i)][index2.get(j)];
					}
				}
				int si = Math.abs(sum1-sum2);
				if(si<min) {
					min = si;
				}
				return;
			} else return;
		}
		index1.add(idx);
		deli(idx+1,count+1, index1, index2);
		index1.remove(index1.size()-1);
		index2.add(idx);
		deli(idx+1,count, index1, index2);
		index2.remove(index2.size()-1);
}
}