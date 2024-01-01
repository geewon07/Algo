import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0 ;

        for(int i=1;i<=500;i++) {
            for(int j=1;j<=500;j++) {
                if(i*i == j*j + N) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}