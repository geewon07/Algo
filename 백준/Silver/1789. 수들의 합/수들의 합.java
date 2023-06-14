import java.io.*;
import java.util.*;
 
public class Main {
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         long a = Long.parseLong(br.readLine());
         long ans = 0;
         for(long i=1;i<=a;i++) {
        	 long right = (i*(i+1))/2;
        	 if(right > a) {
        		 ans = i-1;
        		 break;
        	 }else if(right == a) {
        		 ans = i;
        		 break;
        	 }
        }
         System.out.println(ans);
	}
 
}