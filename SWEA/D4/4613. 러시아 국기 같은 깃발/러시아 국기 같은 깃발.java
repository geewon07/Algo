import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char[][] arr;
	static int N,M,min;
	static char[] colors; // 재귀적으로 선택된 행별 색깔을 담을 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new char[N][M];
			colors = new char[N]; //행의 정보만 가지면 되므로
			
			// 2차원 배열 입력받기
			for(int i=0;i<N;i++) {
				String s= br.readLine();
				for(int j=0;j<M;j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			min = Integer.MAX_VALUE;
			
			// select 재귀적으로 행의 색깔을 선택하는 함수
			// 각 선택은 이전 색깔의 영향을 받음
			// select(i) : i번째 행의 색을 선택 => 정보가 충분하지 않음
			// i번째 행의 선택은 i-1번째 행의 색깔에 의존, 영향을 받음
			// select(i, prevcolor) : i-1번째 색이 prevColor일 때, i번째 행의 색을 선택
			select(1, 'W');
			
			// 재귀함수가 다 돌고나면 1번행부터 N-2번행까지 최소값이 min에 저장되어 있어요...
			
			for(int j=0;j<M;j++) {
				if(arr[0][j] != 'W') {
					min++;
				}
				if(arr[N-1][j] != 'R') {
					min++;
				}
			}
			// 0번 행은 어차피 W
			// 1번 ~ N-2번까지만 선택하면 됨
			// N-1번 행은 어차피 R
			System.out.println("#"+tc+" "+min);
		}
	}
    // i-1번째 색이 주어질 때 i번째 색을 선택하는 함수
	// 변수명을 고칠 때 : alt + shift +  R
	private static void select(int i, char c) {
		// 기저 조건
		if(i==N-1) { // N-2까지는 선택을 하고, N-1일 때 멈춤.
			// 선택이 완료되었으므로 개수를 셈
			int colorCnt = 0;
			
			for(int j=1; j < N-1 ; j++) {
				int cnt = 0;
				for(int k=0;k<M;k++) {
					if(arr[j][k] != colors[j]) cnt++;
				}
				colorCnt += cnt;
			}
			
			min = min>colorCnt? colorCnt : min;
			return;
		}
		
		// i가 N-2번째를 선택하려고 하는데...
		// N-3번째 색이 'W' 였으면 => N-2번째는 무조건 'B'가 되도록 선택
		if(i==N-2 && c=='W') {
			colors[i] = 'B';
			select(i+1,'B');
			return;
		}
		// 유도 조건
		if( c == 'W') {
			colors[i] = 'W';
			select(i+1, 'W');
			colors[i] = 'B';
			select(i+1, 'B');
		} else if( c == 'B') {
			colors[i] = 'B';
			select(i+1, 'B');
			colors[i] = 'R';
			select(i+1,'R');
		} else if (c == 'R') {
			colors[i] = 'R';
			select(i+1, 'R');
		}
		
	}

}