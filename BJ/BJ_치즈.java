package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_치즈{
	static int N, M;
	static int[][] map;
	static int[][] cost;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int cnt = 1;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(cnt != 0) {
			cost = new int[N][M];
			visit = new boolean[N][M];
			DFS(0, 0);
			count(0, 0);
			result++;
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(cost[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		System.out.println(result);
		
	}

	private static void count(int y, int x) {
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(cost[i][j] >= 2) {
					map[i][j] = 0;
				}
				if(map[i][j] == 1) {
					cnt++;
				}
			}
		}
		
	}

	private static void DFS(int y, int x) {
		visit[y][x] = true;
		if (map[y][x] == 1) { // 占쏙옙 탐占쏙옙 占쏙옙 1 占쏙옙 占쏙옙
			for (int i = 0; i < 4; i++) { // 占쏙옙占쏙옙 占쏙옙치占쏙옙 占싱듸옙
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx]) {
					continue;
				}if(map[ny][nx] == 1) continue;
				DFS(ny, nx);
			}
		} else { // 占쏙옙 탐占쏙옙 占쏙옙 0 占쏙옙 占쏙옙
			for (int i = 0; i < 4; i++) { // 占쌍븝옙占쏙옙 치占쏘가 占쌍댐옙 占쏙옙 확占쏙옙
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					continue;
				}
				if(map[ny][nx] == 1) {
					cost[ny][nx]++; // 치占쏘가 占쏙옙占쏙옙 占쏙옙占� 占쏙옙占� +1
				}
			}
			
			for (int i = 0; i < 4; i++) { // 占쏙옙占쏙옙 占쏙옙치占쏙옙 占싱듸옙
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx]) {
					continue;
				}if(map[ny][nx] == 1) continue;
				DFS(ny, nx);
			}
		}
	}

}
