import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// length 미리 계산해놓고 쓰기 <= 시간 초과 방지
		String str = br.readLine();
		String bomb = br.readLine();
		int str_len = str.length();
		int bomb_len = bomb.length();
		StringBuilder sb = new StringBuilder();
		// split 썼더니 메모리초과
		// 자바의 string은 불변이라서 값을 바꿀때마다 새로운 String을 할당하기 때문에ㅠㅠㅠ...
		
		// stack or StringBuilder
		Stack<Character> stack = new Stack<>();

		for(int i=0; i<str_len; i++) {
			int count = 0;
			stack.push(str.charAt(i));

			if(stack.size() >= bomb_len) {

				for(int j=0; j<bomb_len; j++) {

					if(stack.get(stack.size() - bomb_len + j) == bomb.charAt(j)) {
						count++;
					}	

					if(count == bomb_len) {
						for(int k=0; k<bomb_len; k++) {
							stack.pop();
						}
					}

				}
			}
		}
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			for(char ch : stack) {
				sb.append(ch);
			}
		}

		System.out.println(sb);
	}
}
