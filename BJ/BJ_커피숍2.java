package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Ŀ�Ǽ�2 {
	static int N, Q;
	static int[] arr;
	static long[] tree;
	static int x, y, a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		tree = new long[N * 4];
		
		init(1, N, 1);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(x > y) {
				int temp = y;
				y = x;
				x = temp;
			}
			
			sb.append(prefix_sum(1, N, 1, x, y) + "\n");
			update(1, N, 1, a, b);
		}
		
		System.out.println(sb.toString());

	}

	private static long update(int start, int end, int node, int idx, long val) {
		if(idx < start || idx > end) {
			return tree[node];
		}
		
		
		if(start == end) {
			return tree[node] = val;
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = update(start, mid, node * 2, idx, val) + update(mid + 1, end, node * 2 + 1, idx, val);
		
	}

	private static long prefix_sum(int start, int end, int node, int left, int right) {
		if(left > end || right < start) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		
		return prefix_sum(start, mid, node * 2, left, right) + prefix_sum(mid + 1, end, node * 2 + 1, left, right);
	}

	private static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
		
	}

}
