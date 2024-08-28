
import java.util.*;
import java.io.*;

public class Main { // 누적합으로 풀었을 때
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] harr = new int[w];
        int answer = 0;
        int[] prefix_max = new int[w+2];
        int[] suffix_max = new int[w+2];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<w;i++) {
            harr[i] = Integer.parseInt(st.nextToken());
            prefix_max[i+1] = Math.max(prefix_max[i], harr[i]);
        }
        for(int i=w-1;i>=0;i--) {
            suffix_max[i+1] = Math.max(suffix_max[i+2],harr[i]);
        }

        for(int i=0;i<w;i++) {
            int curr = Math.min(prefix_max[i+1],suffix_max[i+1]);
            if(harr[i] < curr ) answer += curr - harr[i];
        }


        System.out.println(answer);
    }
}