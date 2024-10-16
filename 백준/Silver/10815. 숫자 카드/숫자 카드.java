import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++) {
            int num = Integer.parseInt(st.nextToken());

            if(binarySerarch(num)) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }

    public static boolean binarySerarch(int num) {
        int start = 0, end = N-1;

        while(start <= end) {
            int mid = (start+end) /2 ;

            if(arr[mid] == num) return true;
            else if(arr[mid] < num) start = mid + 1;
            else end = mid -1;
        }
        return false;
    }
}
