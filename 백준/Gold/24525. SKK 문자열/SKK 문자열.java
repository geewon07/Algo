import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int answer = -1;
        int before = 0;
        boolean find = false;
        int lastAnswer = -1;

        for(int i=1;i<=str.length();i++) {
            switch(str.charAt(i-1)) {
                case 'S' :
                    find = true;
                    before += 2;
                    break;
                case 'K' :
                    before--;
            }
            if(map.containsKey(before)) {
                if(find) {
                    if(str.charAt(i-1) == 'S' || str.charAt(i-1) == 'K' || lastAnswer == i - 1) {
                        answer = Math.max(answer, i - map.get(before));
                        lastAnswer = i;
                    }
                }
            } else {
                map.put(before,i);
            }
        }

        System.out.print(answer);
    }
}