import java.io.*;
import java.util.*;


public class Main {
    static int N,S;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        recur(0,0);

        if(S==0) answer--; // S = 0일 때 공집합 카운트 됨!
        System.out.println(answer);
    }

    private static void recur(int count, int sum) {
        if(count == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }
        recur(count+1, sum + arr[count]);
        recur(count+1, sum);
    }


}