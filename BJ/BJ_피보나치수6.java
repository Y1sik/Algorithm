package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_피보나치수6 {
	final static long MOD = 1000000007;
	static long[][] origin = { { 1, 1 }, { 1, 0 } };
	static long N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());

		System.out.println(pow(origin, N - 1)[0][0]);

	}

	private static long[][] pow(long[][] A, long exp) {
		if (exp == 1 || exp == 0) {
			return A;
		}

		long[][] ret = pow(A, exp / 2);

		ret = multiply(ret, ret);

		if (exp % 2 == 1L) {
			ret = multiply(ret, origin);
		}
		return ret;
	}

	private static long[][] multiply(long[][] o1, long[][] o2) {
		long[][] ret = new long[2][2];

		ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
		ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
		ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
		ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;
		return ret;
	}

}
