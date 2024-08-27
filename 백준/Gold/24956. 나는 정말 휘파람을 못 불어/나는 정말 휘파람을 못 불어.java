
import java.util.*;
import java.io.*;

public class Main {
    static int mod = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long[] prefixSum = new long[3];
        long ans = 0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == 'W') {
                prefixSum[0]++;
            }else if(s.charAt(i) == 'H') {
                prefixSum[1] += prefixSum[0];
            }else if(s.charAt(i) == 'E') {
                ans = (2*ans+prefixSum[2])%mod;
                prefixSum[2] += prefixSum[1];
            }
        }

        System.out.println(ans);
    }
}