package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_¥Ò {
	static long MOD = 1000000007;
	static int m;
	static int n, s;
	static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			int gcd = gcdBetween(n > s ? n : s, n < s ? n : s);
			int a = s / gcd;
			int b = n / gcd;
			result = (result + (long)a * InverseOf(b)) % MOD;
		}
		System.out.println(result);
		
	}

	private static long InverseOf(int n) {
		return Power(n, MOD - 2);
	}

	private static long Power(int base, long exp) {
		if (exp == 1L) {
			return base;
		}
		
		long ret = Power(base, exp / 2L);
		if(exp % 2L == 1L) {
			return (ret * ret * base) % MOD;
		}
		return (ret * ret) % MOD;
	}

	private static int gcdBetween(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcdBetween(b, a % b);
	}

	

}
