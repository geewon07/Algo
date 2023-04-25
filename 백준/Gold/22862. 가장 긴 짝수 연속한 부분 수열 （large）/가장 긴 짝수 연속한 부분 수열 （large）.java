import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
        int i = 0; // 짝수 수열의 시작 지점
        int j = 0; // 짝수 수열의 현재 지점
        int cnt = 0;
        
        while (j < N) {
            if (cnt < K) {
                if (arr[j] % 2 != 0) {
                	cnt++;
                }
                j++;
                ans = Math.max(j - i - cnt, ans); 
            } else if (arr[j] % 2 == 0) {
                j++;
                ans = Math.max(j - i - cnt, ans);
            } else {
                if (arr[i] % 2 != 0) {
                	cnt--;
                }
                i++;
            }
        }

        System.out.println(ans);
    }
}