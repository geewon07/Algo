import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;
		int min = Integer.MAX_VALUE;
		boolean cnt = false ;
		
		for(int i=0;i<=N/3;i++) {
			count = 0;
			for(int j=0;j<=N/5;j++) {
				count = i + j;
				if((i*3) + (j*5) == N) {
					cnt = true;
					if(count < min) {
						min = count;
					}
				}
			}
		}
		if(cnt) System.out.println(min);
		else System.out.println(-1);
		
	}

}