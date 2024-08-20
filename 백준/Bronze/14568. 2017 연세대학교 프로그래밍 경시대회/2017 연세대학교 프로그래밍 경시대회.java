
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0 ;

        for(int 택희=1;택희<N+1;택희++) {
            for(int 영훈=1;영훈<N+1;영훈++) {
                for(int 남규=1;남규<N+1;남규++) {
                    if(택희 + 영훈+ 남규 != N ) continue;
                    if(남규<영훈+2) continue;
                    if(택희%2 == 1) continue;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}