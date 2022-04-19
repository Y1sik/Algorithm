package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_가장큰증가부분수열 {
	static int N;
	static int[] A;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = A[0];
		
		int result = seq();
		System.out.println(result);

	}
	private static int seq() {
		for (int i = 1; i < N; i++) {
			dp[i] = A[i];
			for (int j = 0; j < N; j++) {
				if(A[i] > A[j]) {
					dp[i] = Math.max(dp[j] + A[i], dp[i]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

}
