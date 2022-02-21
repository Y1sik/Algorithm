package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_NQueen {
	static int N;
	static int[] board; // 값이 행, index가 열
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		board = new int[N];

		NQueen(0);
		
		System.out.println(cnt);
	}

	private static void NQueen(int depth) {
		if(depth == N) { // 재귀가 완료 되었다
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			board[depth] = i;
			if(Success(depth)) { // 체스 둘 수 있는 곳
				NQueen(depth + 1);
			}
		}
		
	}

	private static boolean Success(int col) {
		// [2, 0, 3, 1]
		for(int i = 0; i < col; i++) {
			if(board[col] == board[i]) { // 같은 행일 경우
				return false;
			}
			
			else if(Math.abs(col - i) == Math.abs(board[col] - board[i]) ) { // 열의 차이와 행의 차이가 같으면 대각선이다
				return false;
			}
		}
		
		return true;
	}

}
