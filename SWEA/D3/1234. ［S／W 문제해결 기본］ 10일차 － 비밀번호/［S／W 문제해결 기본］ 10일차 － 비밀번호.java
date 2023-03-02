
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int N = sc.nextInt();
			String s = sc.next();
			
			Stack<Character> st = new Stack<>();
				
			for(int i=0;i<s.length();i++) {
				if(st.isEmpty()) {
					st.add(s.charAt(i));
				} else {
				  char c = st.peek();
				  if(c==s.charAt(i)) {
					st.pop();
				} else {
					st.add(s.charAt(i));
					}
				}
			}

			System.out.print("#"+tc+" ");
			for(int i=0;i<st.size();i++) {
				System.out.print(st.get(i));
			}
//			System.out.println(ans);
////			
////			for(int i=ans.length()-1;i>=0;i--) {
//				System.out.print(ans.charAt(i));
//			}
			System.out.println();
			}
		}
	}


