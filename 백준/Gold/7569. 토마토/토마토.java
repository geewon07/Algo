import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N,H,result;
    static int[][][] arr;
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = { 0, 0, 0, 0, 1, -1};
    static int tomatosize, eattomatosize;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        q = new LinkedList<>();
        
        arr = new int[H][N][M];
        tomatosize = H*N*M;
        eattomatosize = 0;
        
        result = -1;
        
        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++) {
                    arr[i][j][k] = Integer.parseInt(st1.nextToken());
                    if(arr[i][j][k] == -1 ) tomatosize--;
                    if(arr[i][j][k] == 1) {
                    	q.add(new int[] {i,j,k,0});
                    	eattomatosize++;
                    }
                }
            }
        }
        
        if(eattomatosize == tomatosize) System.out.println(0);
        else {
        	eat();
        	if(eattomatosize == tomatosize) System.out.println(result);
        	else System.out.println(-1);
        }
    }
    // 1. 안 익은거를 기준으로 주변에 익은게 있다면  0 -> 1 값으로 바꾸어 준다. q가 비었을 때 => 아직도 0이 남아있다면 -1 반환
    // 2. visited 이용
    // 3.
	private static void eat() {
		while(!q.isEmpty()) {
			int[] nums = q.poll();
			for(int i=0;i<6;i++) {
				int nh = nums[0] + dh[i];
                int nr = nums[1] + dr[i];
                int nc = nums[2] + dc[i];
                int count = nums[3];
                
                if(nh>=0 && nh<H && nr>=0 && nr<N && nc>=0 && nc<M && arr[nh][nr][nc] == 0) {
                	arr[nh][nr][nc] = 1;
                	q.add(new int[]{nh,nr,nc,count+1});
                	eattomatosize++;
                	result = Math.max(count+1, result);
                }
			}
		}
		
		
	}
}