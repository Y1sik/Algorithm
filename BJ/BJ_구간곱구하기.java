package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_구간곱구하기 {
	static int N, M, K;
	static long[] arr, tree;
	static int a, b; 
	static long c;
	final static long MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		tree = new long[N * 4];
		
		Init(1, N, 1);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if(a == 1) {
				arr[b] = c;
				Update(1, N, 1, b, c);
			}
			else if(a == 2) {
				sb.append(Mul(1, N, 1, b, (int)c) + "\n");
			}
		}
		
		System.out.println(sb.toString());

	}

	private static long Mul(int start, int end, int node, int left, int right) {
		if(left > end || right < start) {
			return 1;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		return (Mul(start, mid, node * 2, left, right) * Mul(mid + 1, end, node * 2 + 1, left, right)) % MOD;
	}

	private static long Update(int start, int end, int node, int idx, long val) {
		if(idx < start || end < idx) {
			return tree[node];
		}
		
		if(start == end) {
			return tree[node] = val;
		}
		
		int mid = (start + end) / 2;
		return tree[node] = (Update(start, mid, node * 2, idx, val) * (Update(mid + 1, end, node * 2 + 1, idx, val)) % MOD);
		
	}

	public static long Init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;

		return tree[node] = (Init(start, mid, node * 2) * Init(mid + 1, end, node * 2 + 1)) % MOD;
	}
	
	

}
