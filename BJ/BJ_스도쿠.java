package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_스도쿠 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sudoku(0, 0);

	}

	private static void sudoku(int row, int col) {
		
		if(col == 9) { // 행이 다 채워졌을때
			sudoku(row + 1, 0); // 다음 행의 첫 번째 열부터 시작
			return;
		}
		
		if(row == 9) { // 행과 열이 다채워짐
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
			System.exit(0); // 출력했으니 종료
		}
		
		if (map[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (possibility(row, col, i)) { // 들어가도 되는지
					map[row][col] = i; 
					sudoku(row, col + 1); // 열 인덱스 증가
				}
			}
			
			map[row][col] = 0; // 다시 원래대로 돌려놓음 
			return;
		}
		
		sudoku(row, col + 1); // 0이 아니면 다음 열로 이동

	}

	private static boolean possibility(int row, int col, int value) {
		for (int i = 0; i < 9; i++) { // 같은 행 같은 값이 있을 경우
			if (map[row][i] == value) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) { // 같은 열에 같은 값이 있을 경우
			if (map[i][col] == value) {
				return false;
			}
		}

		int r = (row / 3) * 3;
		int c = (col / 3) * 3;
		
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) { // 3x3에 같은 값이 있을 경우
				if(map[i][j] == value) {
					return false;
				}
			}
		}
		
		return true; // 중복되는 것이 없을 경우 true 반환
	}

}
