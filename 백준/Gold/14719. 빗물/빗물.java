
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] harr = new int[w];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<w;i++) {
            harr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=h;i>=1;i--) {
            int count = 0;
            boolean check = false;
            for(int j=0;j<w;j++) {
                if(harr[j] >= i) {
                    check = true;
                    answer += count;
                    count = 0;
                }else {
                    if(check) count++;
                }
//                System.out.println(i+" :높이 " + j+" :지금 위치 "+count+" :count값 "+answer+" answer 값 "+check+"harr[j]의 값: "+harr[j]);
            }
        }
        System.out.println(answer);
    }
}