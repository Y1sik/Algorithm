package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_구간합구하기4 {
	static int N, M;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		dp = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Prefix_Sum(a, b);
		}

	}
	private static void Prefix_Sum(int a, int b) {
		System.out.println(dp[b] - dp[a-1]);
	}

}
