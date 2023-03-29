import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] check = new int[M];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		Set<Integer> s = new HashSet<>();
		
		s.add(arr[0]);
		s.add(0);
		
		for(int i=1;i<N;i++) {
			List<Integer> list = new ArrayList<Integer>();
			for(int num : s ) {
				list.add(Math.abs(num-arr[i]));
				list.add(num+arr[i]);
			}
			s.add(arr[i]);
			s.addAll(list);
		}
		
		for(int i=0;i<M;i++) {
			if(s.contains(check[i])) System.out.print("Y"+" ");
			else System.out.print("N"+" ");
		}
		
		}
}