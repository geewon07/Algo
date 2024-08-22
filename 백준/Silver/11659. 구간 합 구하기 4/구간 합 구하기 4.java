
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] psum = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1;i<n+1;i++) {
            int c = Integer.parseInt(st.nextToken());
            psum[i] = psum[i-1] + c;
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            System.out.println(psum[l]-psum[f-1]);
        }
    }
}