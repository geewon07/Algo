
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());

        int s = 1;
        int e = 2;

        StringBuilder sb = new StringBuilder();
        boolean check = false;

        while(s<e && e<g) {
            int res = e*e - s*s;

            if(res<g) e++;
            else if(res>g) s++;
            else {
                check = true;
                sb.append(e).append("\n");
                e++;
                s++;
            }
        }
        System.out.println(check? sb: -1);
    }
}