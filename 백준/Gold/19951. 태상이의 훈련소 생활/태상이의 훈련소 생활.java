import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //연병장의 크기
        int M = Integer.parseInt(st.nextToken()); //조교의 수

        int[] H = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i <= N; i++){
            H[i] = Integer.parseInt(st.nextToken());
        }

        // imos : 구간 update -> 점 update로!
        int[] sum = new int[N+2]; // 이렇게 해두면 굳이 if문 처리 안해도됨!
        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            //누적합
            sum[a] += k;
            sum[b+1] -= k;
        }
        for(int i =1;i<=N;i++){
            sum[i] += sum[i-1];
            H[i] +=sum[i];
        }

        //print
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= N; i++){
            sb.append(H[i]).append(" ");
        }

        System.out.println(sb);
    }
}
