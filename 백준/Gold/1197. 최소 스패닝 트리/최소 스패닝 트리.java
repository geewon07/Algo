import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] p ;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        p = new int[V+1];
        int[][] map = new int[E][3];
        
        for(int i=0;i<E;i++) {
        	st = new StringTokenizer(br.readLine());
        	map[i][0] = Integer.parseInt(st.nextToken());
        	map[i][1] = Integer.parseInt(st.nextToken());
        	map[i][2] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(map, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
        
        for(int i=1;i<V+1;i++) {
        	p[i] = i;
        }
        
        int ans = 0;
        int pick = 0;
        
        for(int i=0;i<E;i++) {
        	int px = findset(map[i][0]);
        	int py = findset(map[i][1]);
        	
        	if( px != py ) {
        		union(px,py);
        		ans += map[i][2];
        		pick++;
        	}
        	if(pick == V-1) break;
        }
        
        System.out.println(ans);
    }
    static int findset(int x) {
    	if(x!=p[x]) 
    		p[x] = findset(p[x]);
    	return p[x];
    }
    static void union(int x, int y) {
    	p[y] = x;
    }
}