package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_인구이동 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Node> al = new ArrayList<>();
	static int result;

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = unite();
		System.out.println(result);
	}

	private static int unite() {
		int result = 0;
		while (true) {
			boolean flag = false;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						int sum = bfs(i, j);
						if (al.size() > 1) {
							colc(sum);
							flag = true;
						}
					}
				}
			}

			if (!flag) return result;
			result++;
		}

	}

	private static void colc(int sum) {
		int avg = sum / al.size();
		for (Node now : al) {
			map[now.y][now.x] = avg;
		}

	}

	private static int bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		al = new ArrayList<>();

		queue.offer(new Node(y, x));
		al.add(new Node(y, x));
		visit[y][x] = true;

		int sum = map[y][x];
		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[ny][nx]) continue;
				int sub = Math.abs(map[now.y][now.x] - map[ny][nx]);
				if (L < sub && sub > R) continue;

				queue.offer(new Node(ny, nx));
				al.add(new Node(ny, nx));
				sum += map[ny][nx];
				visit[ny][nx] = true;

			}
		}
		return sum;
	}

}
