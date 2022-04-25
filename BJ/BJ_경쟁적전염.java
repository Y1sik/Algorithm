package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_∞Ê¿Ô¿˚¿¸ø∞ {
	static int N, K;
	static int[][] map;
	static int S, X, Y;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		int result = virus();
		System.out.println(result);

	}

	private static int virus() {
		loop: for (int i = 0; i < S; i++) {
			for (int j = 1; j <= K; j++) {
				bfs(j);

				if (map[X - 1][Y - 1] != 0) {
					break loop;
				}
			}
		}
		int result = map[X - 1][Y - 1];
		return result;
	}

	private static void bfs(int k) {
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == k) {
					q.add(new Node(j, i));
				}
			}
		}

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int z = 0; z < 4; z++) {
				int nx = node.x + dx[z];
				int ny = node.y + dy[z];
				if (isRange(nx, ny)) {
					map[ny][nx] = k;
				}
			}
		}

	}

	private static boolean isRange(int nx, int ny) {
		if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[ny][nx] != 0) {
			return false;
		}
		return true;
	}

}
