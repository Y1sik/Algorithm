package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2048Easy {
	static int N;
	static int[][] map;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		game(0);
		System.out.println(result);
	}

	private static void game(int index) {
		if (index == 5) {
			findMax();
			return;
		}
		int copy[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}

		for (int i = 0; i < 4; i++) {
			move(i);
			game(index + 1);
			for (int j = 0; j < N; j++) {
				map[j] = copy[j].clone();
			}
		}

	}

	private static void findMax() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					result = Math.max(result, map[i][j]);
				}
			}
		}

	}

	private static void move(int dir) {
		switch (dir) {
		case 0: // ��
			for (int i = 0; i < N; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < N; j++) {
					if (map[j][i] != 0) {
						if (block == map[j][i]) { // ���� ���� ���
							map[index - 1][i] = block * 2; // ���� �ִ� ���� * 2
							block = 0; // �� 0���� �ʱ�ȭ
							map[j][i] = 0; // map �� �ʱ�ȭ
						} else { // ���� �ٸ� ���, �ƹ����� ���� ���
							block = map[j][i]; // block�� ���� ����
							map[j][i] = 0; // map�� �ʱ�ȭ
							map[index][i] = block; // block ���� ��ġ�� �������� ���� ���� �ø�
							index++; // �ٷ� ������ index ����
						}
					}
				}
			}
			break;
		case 1: // ��
			for (int i = 0; i < N; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						if (block == map[i][j]) {
							map[i][index - 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						} else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index++;
						}
					}
				}
			}
			break;
		case 2: // ��
			for (int i = 0; i < N; i++) {
				int index = N - 1;
				int block = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] != 0) {
						if (block == map[j][i]) {
							map[index + 1][i] = block * 2;
							block = 0;
							map[j][i] = 0;
						} else {
							block = map[j][i];
							map[j][i] = 0;
							map[index][i] = block;
							index--;
						}
					}
				}
			}
			break;
		case 3: // ��
			for (int i = 0; i < N; i++) {
				int index = N - 1;
				int block = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] != 0) {
						if (map[i][j] == block) {
							map[i][index + 1] = block * 2;
							block = 0;
							map[i][j] = 0;
						} else {
							block = map[i][j];
							map[i][j] = 0;
							map[i][index] = block;
							index--;
						}
					}
				}
			}
			break;
		}
	}

}
