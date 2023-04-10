import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int X = Integer.parseInt(br.readLine());
    	
    	int[] dp = new int[X+2];
    	
    	for(int i=2;i<X+1;i++) {
    		 int min = dp[i-1]+1;
    		 
    		 if(i%3 == 0) min = Math.min(min, dp[i/3]+1);
    		 if(i%2 == 0) min = Math.min(min, dp[i/2]+1);
    		 
    		 dp[i] = min;
            	}
    	System.out.println(dp[X]);
    	
    		}
    }