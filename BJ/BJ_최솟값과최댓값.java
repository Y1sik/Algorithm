package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_ÃÖ¼Ú°ª°úÃÖ´ñ°ª {
	static int N, M;
	static long[] arr, mintree, maxtree;
	static long a, b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		mintree = new long[N * 4];
		maxtree = new long[N * 4];
		
		minInit(1, N, 1);
		maxInit(1, N, 1);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			
			sb.append(minFind(1, N, 1, a, b) + " " + maxFind(1, N, 1, a, b) + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static long maxFind(int start, int end, int node, long left, long right) {
		if(start > right || end < left) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return maxtree[node];
		}
		
		int mid = (start + end) / 2;
		
		return Math.max(maxFind(start, mid, node * 2, left, right), maxFind(mid + 1, end, node * 2 + 1, left, right));
	}

	private static long minFind(int start, int end, int node, long left, long right) {
		if(start > right || end < left) {
			return Integer.MAX_VALUE;
		}
		
		if(left <= start && end <= right) {
			return mintree[node];
		}
		
		int mid = (start + end) / 2;
		
		return Math.min(minFind(start, mid, node * 2, left, right), minFind(mid + 1, end, node * 2 + 1, left, right));
	}

	private static long maxInit(int start, int end, int node) {
		if(start == end) {
			return maxtree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		return maxtree[node] = Math.max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
		
	}
	private static long minInit(int start, int end, int node) {
		if(start == end) {
			return mintree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		return mintree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
		
	}

}
