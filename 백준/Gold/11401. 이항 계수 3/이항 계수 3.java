import java.io.*;
import java.util.*;

// 이항계수 (n k) = nCk = n!/k!*(n-k)!
// 문제에서 요구하는 것 => n!/k!*(n-k)!%1000000007
// 모듈러 연산을 이용함 (% = mod)
// BUT, 모듈러 연산에서 / 연산 없음
// => 분모인 k!*(n-k)!을 역린으로 만든다. == (k!*(n-k)!)의 -1제곱
// => 이는 페르마의 소정리를 이용함

// => ((N! mod p) * (K!(N-K)!)의 1000000007-2제곱 mod p) mod p
public class Main {
	static long P = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N, K입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		
		// 분자 N!
		long num1 = factorial(N);
		
		// 분모 K!(N-K)!
		long num2 = factorial(K) * factorial(N - K) % P;
		
		// 분모의 역린 
		num2 = pow(num2, P - 2);
		
		// 출력 
		System.out.println(num1 * num2 % P);
		
	}
	
	// 팩토리얼 함수
	static long factorial(long n) {
		long result = 1L;
		while (n > 1) {
			result = (result * n--) % P;
		}
		return result;
	}
	
	// 역린 구하는 함수
	// 밑(base), 지수(exponent)
	// 거듭 제곱을 분할 정복하기
	static long pow(long base, long exponent) {
		// 지수가 1이면 그냥 그대로...
		if (exponent == 1) return base % P;
		
		// 지수의 절반 구하기
		long half = pow(base, exponent / 2);
		
		// 현재 지수가 홀수면 base 한 번 더 곱해주기
		if (exponent % 2 == 1) return (half * half % P) * base % P;
		
		return half * half % P;
	}
	 
}