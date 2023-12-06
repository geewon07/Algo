import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        
        for(int i=0; i< a.length();i++) {
            char s = a.charAt(i);
            if(Character.isUpperCase(s)) {
                answer += Character.toLowerCase(s);
            } else {
                answer += Character.toUpperCase(s);
            }
        }
        System.out.println(answer);
    }
}