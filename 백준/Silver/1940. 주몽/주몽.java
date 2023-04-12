import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
// 완전탐색, 시뮬레이션, DFS or BFS
 
public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = N-1;
        int ans = 0;
        
        while(left<right) {
        	if(arr[left] + arr[right] == M) {
        		ans++;
        		left++;
        		right--;
        	} else if(arr[left] + arr[right] < M)
        		left ++;
        	else right--;
        }
        
        System.out.println(ans);
    }
}