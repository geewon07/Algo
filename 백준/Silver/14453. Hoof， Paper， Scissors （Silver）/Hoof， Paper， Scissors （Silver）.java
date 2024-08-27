
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prefix_win_h = new int[n+1];
        int[] prefix_win_s = new int[n+1];
        int[] prefix_win_p = new int[n+1];

        for(int i=1;i<n+1;i++) {
             char gesture = br.readLine().charAt(0);
            prefix_win_h[i] = prefix_win_h[i-1];
            prefix_win_s[i] = prefix_win_s[i-1];
            prefix_win_p[i] = prefix_win_p[i-1];
            if(gesture == 'P') {
                prefix_win_s[i]++;
            }else if(gesture == 'H') {
                prefix_win_p[i]++;
            }else {
                prefix_win_h[i]++;
            }
        }

        int answer = Math.max(prefix_win_h[n],Math.max(prefix_win_s[n],prefix_win_p[n]));
        for(int i=2;i<n+1;i++) {
             int left_max = Math.max(prefix_win_h[i-1],Math.max(prefix_win_s[i-1],prefix_win_p[i-1]));
             int right_max = Math.max(prefix_win_h[n]-prefix_win_h[i-1],Math.max(prefix_win_s[n]-prefix_win_s[i-1],prefix_win_p[n]-prefix_win_p[i-1]));
             answer = Math.max(answer,left_max+right_max);
        }
        System.out.println(answer);
    }
}