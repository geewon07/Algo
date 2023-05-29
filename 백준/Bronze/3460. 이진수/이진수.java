import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());

	StringBuilder sb = new StringBuilder();
	for(int tc=1;tc<=T;tc++) {
		
		int n = Integer.parseInt(br.readLine());
		int i = 0;
		if(n == 1) sb.append(0).append(" ");
		while(n>1) {
			if(n%2 == 1) sb.append(i).append(" ");
			n = n/2;
			if(n == 1) sb.append(i+1).append(" ");
			i++;
		}
		sb.append("\n");
	}
	System.out.println(sb);
	
	}
}
