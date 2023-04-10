import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[][] map = new int[N+1][3];
    	
    	for(int i=1;i<N+1;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		map[i][0] = Integer.parseInt(st.nextToken());
    		map[i][1] = Integer.parseInt(st.nextToken());
    		map[i][2] = Integer.parseInt(st.nextToken());
    	}
    	int[][] dpmax = new int[N+1][3];
    	int[][] dpmin = new int[N+1][3];
    	
    	for(int i=1;i<N+1;i++) {
    		dpmax[i][0] = Math.max(dpmax[i-1][0],dpmax[i-1][1]) + map[i][0];
    		dpmax[i][1] = Math.max(dpmax[i-1][2], Math.max(dpmax[i-1][0],dpmax[i-1][1])) + map[i][1];
    		dpmax[i][2] = Math.max(dpmax[i-1][1],dpmax[i-1][2]) + map[i][2];
    		dpmin[i][0] = Math.min(dpmin[i-1][0],dpmin[i-1][1]) + map[i][0];
    		dpmin[i][1] = Math.min(dpmin[i-1][2], Math.min(dpmin[i-1][0],dpmin[i-1][1])) + map[i][1];
    		dpmin[i][2] = Math.min(dpmin[i-1][1],dpmin[i-1][2]) + map[i][2];
    	}
    	
    	System.out.print(Math.max(dpmax[N][2], Math.max(dpmax[N][0],dpmax[N][1]))+" ");
    	System.out.println(Math.min(dpmin[N][2], Math.min(dpmin[N][0],dpmin[N][1])));
    }
    
    }