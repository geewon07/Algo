import java.io.*;
import java.util.*;
 
public class Main {
	public static Stack<Character> stack=new Stack<Character>();
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		boolean f=false;
		long ans=0;
		int val=1;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				stack.add(s.charAt(i));
				val*=2;
			}
			if(s.charAt(i)=='[') {
				stack.add(s.charAt(i));
				val*=3;
			}
			if(s.charAt(i)==')') {
				if(stack.empty() || stack.peek()!='(') {
					f=true;
					break;
				}if(s.charAt(i-1)=='(')
					ans+=val;
				stack.pop();
				val/=2;
				
			}else if(s.charAt(i)==']') {
				if(stack.empty() || stack.peek()!='[') {
					f=true;
					break;
				}
				if(s.charAt(i-1)=='[')
					ans+=val;
				stack.pop();
				val/=3;
			}
		}
		if(f==true || !stack.empty()) {
			System.out.println(0);
		}else {
			System.out.println(ans);
		}
	}

}