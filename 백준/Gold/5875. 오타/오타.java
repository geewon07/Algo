import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int open = 0, close = 0, count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                open++;
                count++;
            } else {
                close++;
                count--;
            }

            if (count <= 1) open = 0;
            if (count == -1) {
                System.out.println(close);
                return;
            }
        }

        System.out.println(open);
    }
}