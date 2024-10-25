import java.io.*;
import java.util.*;


public class Main {
    static int T,N;
    static int[] arr;
    static int dist;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc=0;tc<T;tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for(int i=0;i<N;i++) {
                for(int j=i+1;j<N;j++) {
                    dist = arr[j]-arr[i];
                    binarySearch(j, N-1);
                }
            }
            System.out.println(answer);
        }
    }
    static void binarySearch(int s,int e) {
        int mid;
        int value = arr[s] + dist;
        while(s<=e){
            mid = (s+e)/2;

            if(arr[mid] < value) s = mid + 1;
            else if(arr[mid] > value) e = mid -1;
            else {
                answer++;
                return;
            }
        }
    }
}