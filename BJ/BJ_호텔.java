package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_хёез {
	static int C, N;
	static int cost, customer;
	static int[] dp;
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		dp = new int[C + 101];
		Arrays.fill(dp, INF);
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cost = Integer.parseInt(st.nextToken());
			customer = Integer.parseInt(st.nextToken());

			for (int j = customer; j < C + 101; j++) {
				dp[j] = Math.min(dp[j], dp[j - customer] + cost);
			}
		}
		int result = INF;
		for (int i = C; i < C + 101; i++) {
			result = Math.min(result, dp[i]);
		}
		System.out.println(result);

	}

}
