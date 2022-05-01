package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_������ {
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
		
		if(col == 9) { // ���� �� ä��������
			sudoku(row + 1, 0); // ���� ���� ù ��° ������ ����
			return;
		}
		
		if(row == 9) { // ��� ���� ��ä����
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
			System.exit(0); // ��������� ����
		}
		
		if (map[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (possibility(row, col, i)) { // ���� �Ǵ���
					map[row][col] = i; 
					sudoku(row, col + 1); // �� �ε��� ����
				}
			}
			
			map[row][col] = 0; // �ٽ� ������� �������� 
			return;
		}
		
		sudoku(row, col + 1); // 0�� �ƴϸ� ���� ���� �̵�

	}

	private static boolean possibility(int row, int col, int value) {
		for (int i = 0; i < 9; i++) { // ���� �� ���� ���� ���� ���
			if (map[row][i] == value) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) { // ���� ���� ���� ���� ���� ���
			if (map[i][col] == value) {
				return false;
			}
		}

		int r = (row / 3) * 3;
		int c = (col / 3) * 3;
		
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) { // 3x3�� ���� ���� ���� ���
				if(map[i][j] == value) {
					return false;
				}
			}
		}
		
		return true; // �ߺ��Ǵ� ���� ���� ��� true ��ȯ
	}

}
