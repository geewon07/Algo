import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int people = 0;
	int ans = 0;
	
	for(int i=1;i<=10;i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int out = Integer.parseInt(st.nextToken());
		int in = Integer.parseInt(st.nextToken());
		
		people = people - out + in;
		
		if(people > ans ) ans = people;
	}
    System.out.println(ans);
	
	}
}
