import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int count = 0;
        int answer = 0;


        for(int i=1;i<n;i++) {
            if( a * i + b * (n-i) ==  w) {
                count++;
                answer = i;
            }
        }
        if( count == 1) {
            System.out.println(answer + " "+ (n-answer));
        } else {
            System.out.println(-1);

        }

    }
}