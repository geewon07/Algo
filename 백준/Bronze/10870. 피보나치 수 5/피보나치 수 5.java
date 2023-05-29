import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int n = Integer.parseInt(br.readLine());
	
	arr = new int[n+1];
	
	arr[0] = 0;
	if(n>0)arr[1] = 1;
	
	if(n == 0 || n == 1) System.out.println(n);
	else System.out.println(fifo(n));
	}
	
	public static int fifo(int n) {
		if(n == 0 || n == 1) {
			return arr[n];
		}else if(arr[n] != 0) return arr[n];
		else {
			arr[n] = fifo(n-1)+fifo(n-2);
			return arr[n];
		}
	}
}
