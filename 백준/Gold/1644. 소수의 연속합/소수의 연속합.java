import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n + 1];
        arr[0] = true;
        arr[1] = true;

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!arr[i]) {
                for (int j = i * i; j < n + 1; j += i) {
                    arr[j] = true;
                }
            }
        }

        for (int i = 2; i < n + 1; i++) {
            if (!arr[i]) primes.add(i);
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = 0;

        while(true) {
            if(sum == n) {
                ans++;
                sum -= primes.get(start++);
            }else if (sum > n) {
                sum -= primes.get(start++);
            } else {
                if(end == primes.size()) {
                    System.out.println(ans);
                    break;
                }
                sum += primes.get(end++);
            }
        }

    }
}
