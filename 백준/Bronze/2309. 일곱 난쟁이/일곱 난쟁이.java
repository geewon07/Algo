import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static int[] sel;
	static boolean find;
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	arr = new int[9];
	sel = new int[7]; // boolean으로 check 하기
	find = false;
	for(int i=0;i<9;i++) {
		arr[i] = Integer.parseInt(br.readLine());
	}
	set(0,0,0);
	}
	public static void set(int idx, int sidx, int sum) {
		if(sidx == 7 && sum == 100) {
			Arrays.sort(sel);
			for(int i=0;i<7;i++) System.out.println(sel[i]);
			find = true;
			return;
		} else if(sidx == 7) return;
		
		if(idx == 9) return;
		
		if(find == false) {
			sel[sidx] = arr[idx];
			set(idx+1,sidx+1,sum+arr[idx]);
			set(idx+1,sidx,sum);
		}
	}
}
