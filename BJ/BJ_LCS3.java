package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_LCS3 {
	static char[] str1;
	static char[] str2;
	static char[] str3;
	static char[] str4;

	static int[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		str3 = br.readLine().toCharArray();

		dp = new int[str1.length + 1][str2.length + 1][str3.length + 1];
		System.out.println(LCS3(str1.length, str2.length, str3.length));
	}

	private static int LCS3(int x, int y, int z) {
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				for (int k = 1; k <= z; k++) {
					if (str1[i - 1] == str2[j - 1] && str2[j - 1] == str3[k - 1]) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}
				}
			}
		}
		return dp[x][y][z];
	}

}
