package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_LCS2 {
	static char[] str1;
	static char[] str2;

	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();

		dp = new int[str1.length + 1][str2.length + 1];

		System.out.println(LCS(str1.length, str2.length));
//		for (int i = 0; i <= str1.length; i++) {
//			for (int j = 0; j <= str2.length; j++) {
//				if (dp[i][j] == 0) {
//					System.out.print("0 ");
//				} else {
//					System.out.print(dp[i][j] + " ");
//				}
//			}
//			System.out.println();
//		}
		LCS_Words(str1.length, str2.length);
	}

	private static void LCS_Words(int i, int j) {
		Stack<Character> stack = new Stack<>();
		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i][j - 1]) {
				j--;
			} else if (dp[i][j] == dp[i - 1][j]) {
				i--;
			} else {
				stack.push(str1[i - 1]);
				i--;
				j--;
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	private static int LCS(int x, int y) {
		int max = -1;
		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[x][y];
	}

}
