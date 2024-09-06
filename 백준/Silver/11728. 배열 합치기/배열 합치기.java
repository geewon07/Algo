
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arra = new int[n];
        int[] arrb = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arra[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            arrb[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        while(s<n && e<m) {
            if(arra[s] <= arrb[e]) sb.append(arra[s++]+" ");
            else sb.append(arrb[e++]+" ");
        }

        if(s==n) {
            for(int i=e;i<m;i++) {
                sb.append(arrb[i]+" ");
            }
        }
        if(e==m) {
            for(int i=s;i<n;i++) {
                sb.append(arra[i]+" ");
            }
        }
        System.out.println(sb);
    }
}