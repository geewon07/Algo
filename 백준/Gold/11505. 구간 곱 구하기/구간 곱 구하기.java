import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int num= 1000000007;
	static long[] arr, tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		tree = new long[N * 4];

		init(1, N, 1);

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				arr[b] = c;
				update(1, N, 1, b, c);
			} else if (a == 2) {
				sb.append(mul(1, N, 1, b, (int) c) + "\n");
			}
		}

		System.out.println(sb);
	}

	public static long init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;

		return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % num;
	}

	public static long mul(int start, int end, int node, int left, int right) {
		// 범위 밖
		if (left > end || right < start) {
			return 1;
		}

		// 범위 안
		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		return (mul(start, mid, node * 2, left, right) * mul(mid + 1, end, node * 2 + 1, left, right)) % num;
	}

	public static long update(int start, int end, int node, int idx, long val) {
		if (idx < start || idx > end) {
			return tree[node];
		}

		if (start == end) {
			return tree[node] = val;
		}

		int mid = (start + end) / 2;
		return tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val))
				% num;
	}

}