package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_������� {
	static int N;
	static long B;
	static int[][] matrix;
	final static int MOD = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}

		int[][] result = pow(matrix, B);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static int[][] pow(int[][] matrix, long exp) {
		if (exp == 1L) {
			return matrix;
		}

		int[][] ret = pow(matrix, exp / 2);

		ret = multiply(ret, ret);

		if (exp % 2 == 1L) {
			ret = multiply(ret, matrix);
		}
		return ret;
	}

	private static int[][] multiply(int[][] o1, int[][] o2) {
		int[][] ret = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {

					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= MOD; // ��� ���� ������ ������ MOD�� ����������
				}
			}
		}
		return ret;
	}

}
