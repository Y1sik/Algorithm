package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_NQueen {
	static int N;
	static int[] board; // ���� ��, index�� ��
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		board = new int[N];

		NQueen(0);
		
		System.out.println(cnt);
	}

	private static void NQueen(int depth) {
		if(depth == N) { // ��Ͱ� �Ϸ� �Ǿ���
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			board[depth] = i;
			if(Success(depth)) { // ü�� �� �� �ִ� ��
				NQueen(depth + 1);
			}
		}
		
	}

	private static boolean Success(int col) {
		// [2, 0, 3, 1]
		for(int i = 0; i < col; i++) {
			if(board[col] == board[i]) { // ���� ���� ���
				return false;
			}
			
			else if(Math.abs(col - i) == Math.abs(board[col] - board[i]) ) { // ���� ���̿� ���� ���̰� ������ �밢���̴�
				return false;
			}
		}
		
		return true;
	}

}
