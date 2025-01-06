import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;

        char[] arr = new char[N];

        String line = br.readLine();

        for(int i=0;i<line.length();i++) {
            arr[i] = line.charAt(i);
        }

        int s = 0;
        int e = 0;

        int wCount = 0;
        int bCount = 0;

        while(e<N){
            if(arr[e] == 'W'){
                wCount++;
                e++;
            }else{
                bCount++;

                while(bCount>B){
                    if(arr[s] =='W'){
                        wCount--;
                    }else{
                        bCount--;
                    }
                    s++;
                }

                e++;
            }
            if(wCount>=W){
                max = Math.max(max,e-s);
            }
        }

        if(max == Integer.MIN_VALUE) max = 0;

        System.out.println(max);
    }
}