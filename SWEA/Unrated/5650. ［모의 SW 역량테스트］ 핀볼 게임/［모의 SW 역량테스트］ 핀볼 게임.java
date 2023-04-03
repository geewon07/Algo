import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class wormhole {
		int x;
		int y;
		public wormhole(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
    static int N,result,dir;
    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int[][] block = {{},{1,3,0,2},{3,0,1,2},{2,0,3,1},{1,2,3,0},{1,0,3,2}};
    static wormhole[][] holes;
    
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine().trim());
        for(int tc=1;tc<=T;tc++) {
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            holes = new wormhole[5][2];
            
            for(int i=0;i<5;i++) {
            	for(int j=0;j<2;j++) {
            		holes[i][j] = new wormhole(-1,-1);
            	}
            }
            for(int i=0;i<N;i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st1.nextToken());
                    if(map[i][j] > 5) {
                    	if(holes[map[i][j]-6][0].x == -1 && holes[map[i][j]-6][0].y == -1 ) {
                    		holes[map[i][j]-6][0].x = i;
                    		holes[map[i][j]-6][0].y = j;
                    	} else {
                    		holes[map[i][j]-6][1].x = i;
                    		holes[map[i][j]-6][1].y = j;
                    	}
                    }
                }
            }
            result = 0;
            for(int i=0;i<N;i++) {
            	for(int j=0;j<N;j++) {
            		if(map[i][j] == 0) {
            				notzero(i,j);
            		}
            	}
            }
            sb.append(result);
            sb.append("\n");
                       
    } System.out.println(sb);
}
    static boolean check(int nr, int nc) {
        return nr>=0 && nr<N && nc>=0 && nc<N;
    }
    
    static void notzero(int r, int c) {
    	for(int i=0;i<4;i++) {
    		int count = 0;
    		int nr = r;
    		int nc = c;
    		int dir = i;
    		
    		while(true) {
    			// 공이 움직일 곳!
    			nr += dr[dir];
    			nc += dc[dir];
    			// 자기 자신을 만났을 때
    			if(nr == r && nc == c) break;
    			
    			// 만약 벽이라면
    			if(!check(nr,nc)) {
    				dir = block[5][dir];
    				count++;
    			} else if (map[nr][nc] >= 1 && map[nr][nc] <= 5) { // 블록을 만났을 때
    				dir = block[map[nr][nc]][dir];
    				count++;
    			} else if (map[nr][nc] >= 6) { // 웜홀 만났을 때
    				int num = map[nr][nc] - 6;
    				if(holes[num][0].x == nr && holes[num][0].y == nc) {
    					nr = holes[num][1].x;
    					nc = holes[num][1].y;
    				}else {
    					nr = holes[num][0].x;
    					nc = holes[num][0].y;
    				}
    			} else if(map[nr][nc] == -1) break;// 블랙홀을 만났을 때
    		}
    		
    		result = Math.max(count, result);
    	}
           }
}