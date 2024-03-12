import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] info = new int [N][3];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE; 
        for(int i = 0; i<N; i++){ 
            for(int j = 0; j<N; j++){
                for(int q = 0; q<N; q++){
                    int cnt = 0; 
                    for(int w = 0; w<N; w++){ 
                        if((info[i][0] >= info[w][0]) && (info[j][1] >= info[w][1]) && (info[q][2] >= info[w][2])){ // 이길때
                            cnt ++; 
                        }
                    }
                    if(cnt >= K){ 
                        int sum = info[i][0] + info[j][1] + info[q][2]; 
                        if(min > sum) { 
                            min = sum;
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
}