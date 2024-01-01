import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[5];

        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;

        while(true) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (result % arr[j] == 0)
                    cnt++;
            }
            if (cnt >= 3) {
                System.out.println(result);
                return;
            }
            result++;
        }
    }
}