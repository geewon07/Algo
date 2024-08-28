
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String answer;

        for(int i=0;i<n;i++) {
            answer = "YES";
            long s = Long.parseLong(br.readLine());
            for(int j=2;j<=1000000;j++) {
                if(s % j == 0) {
                    answer = "NO";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}