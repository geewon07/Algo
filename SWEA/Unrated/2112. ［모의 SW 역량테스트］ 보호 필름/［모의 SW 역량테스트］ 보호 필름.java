import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	    static int D,W,K;
	    static int[][] arr,copy;
	    static int result;
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine());
	        for(int tc=1;tc<=T;tc++) {
	        	StringTokenizer st= new StringTokenizer(br.readLine());
	        	D = Integer.parseInt(st.nextToken());
	        	W = Integer.parseInt(st.nextToken());
	        	K = Integer.parseInt(st.nextToken());
	        	
	        	arr = new int[D][W];
	        	copy = new int[D][W];
	            result = Integer.MAX_VALUE;
	        	for(int i=0;i<D;i++) {
	        		StringTokenizer st1 = new StringTokenizer(br.readLine());
	        		for(int j=0;j<W;j++) {
	        			arr[i][j] = copy[i][j]=  Integer.parseInt(st1.nextToken());
	        		}
	        	}
	        	if(search()) {
	        		System.out.println("#"+tc+" "+0);
	        	} else {
	        		replay(0,0);
	        		System.out.println("#"+tc+" "+result);
	        	}
	        	
	        }
	    }
	    private static void replay(int count, int idx) {
			if(count >= result) return;
			
			if(idx == D) {
			if(search()) {
				result = Math.min(count, result);
			}
			return;
			}
			replay(count,idx+1);
			
			for(int i=0;i<W;i++) {
				arr[idx][i] = 1;
			}
			replay(count+1,idx+1);
			
			for(int i=0;i<W;i++) {
				arr[idx][i] = 0;
			}
			replay(count+1,idx+1);
			
			for(int i=0;i<W;i++) {
				arr[idx][i] = copy[idx][i];
			}
			
			}
		static boolean search() {
			boolean check = true;
	    	for(int i=0;i<W;i++) {
	    		int count1 = 0;
			    int count2 = 0;
                int cnt = 0;
	    		 for(int j=0;j<D;j++) {
	    			if(arr[j][i] == 1) count1++;
        			else count1 = 0;
        			if(arr[j][i] == 0) count2++;
        			else count2 = 0;
        			if(count1 == K | count2 == K) {
        				cnt = 1;
        				break;
        			}
	    		}
	    		if(cnt == 0) {
	    			check = false;
	    			break;
	    		}
	    	}
	    	if(!check) return false;
	    	else return true;
	    }
	    
	}