package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_°¨½Ã {
	static int N, M;
	static int[][] map;
	static int[][] copy;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static LinkedList<Node> cctvList;
	static int[] dir;
	static int result = Integer.MAX_VALUE;
	static class Node {
		int cctvKind;
		int x;
		int y;
		public Node(int cctvKind, int x, int y) {
			super();
			this.cctvKind = cctvKind;
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cctvList = new LinkedList<>();
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x] != 0 && map[y][x] != 6) {
					cctvList.add(new Node(map[y][x], x, y));
				}
			}
		}
		
		dir = new int[cctvList.size()];
		
		perm(0, cctvList.size());
		
		System.out.println(result);
		
	}

	private static void perm(int depth, int cnt) {
		if(depth == cnt) {
			copy = new int[N][M];
			for (int i = 0; i < map.length; i++) {
				copy[i] = map[i].clone();
			}
			
			for (int i = 0; i < cnt; i++) {
				direction(cctvList.get(i), dir[i]);
			}
			
			blind_Spot();
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			dir[depth] = i;
			perm(depth + 1, cnt);
		}
		
	}

	private static void blind_Spot() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j] == 0) {
					cnt++;
				}
			}
		}
		result = Math.min(result, cnt);
		
	}

	private static void direction(Node cctv, int dir) {
		int cctvKind = cctv.cctvKind;
		if(cctvKind == 1) {
			switch (dir) {
			case 0:
				watch(cctv, 0); // »ó
				break;
			case 1:
				watch(cctv, 1); // ¿ì
				break;
			case 2:
				watch(cctv, 2); // ÇÏ
				break;
			case 3:
				watch(cctv, 3); // ÁÂ
				break;
			}
		}else if(cctvKind == 2) {
			if(dir == 0 || dir == 2) { 
				watch(cctv, 0);
				watch(cctv, 2); // »óÇÏ
			}else if (dir == 1 || dir == 3) {
				watch(cctv, 1);
				watch(cctv, 3); // ÁÂ¿ì
			}
		}else if(cctvKind == 3) {
			switch (dir) {
			case 0:
				watch(cctv, 0);
				watch(cctv, 1); // »ó¿ì
				break;
			case 1:
				watch(cctv, 1);
				watch(cctv, 2); // ¿ìÇÏ
				break;
			case 2:
				watch(cctv, 2);
				watch(cctv, 3); // ÇÏÁÂ
				break;
			case 3:
				watch(cctv, 3);
				watch(cctv, 0); // ÁÂ»ó
				break;
			}
		}else if (cctvKind == 4) {
			switch (dir) {
			case 0:
				watch(cctv, 3);
				watch(cctv, 0);
				watch(cctv, 1); // ÁÂ»ó¿ì
				break;
			case 1:
				watch(cctv, 0);
				watch(cctv, 1);
				watch(cctv, 2); // »ó¿ìÇÏ
				break;
			case 2:
				watch(cctv, 1);
				watch(cctv, 2);
				watch(cctv, 3); // ¿ìÇÏÁÂ
				break;
			case 3:
				watch(cctv, 2);
				watch(cctv, 3);
				watch(cctv, 0); // ÇÏÁÂ»ó
				break;

			}
		} else if (cctvKind == 5) {
			watch(cctv, 0);
			watch(cctv, 1);
			watch(cctv, 2);
			watch(cctv, 3); // »ó¿ìÇÏÁÂ
		}
		
	}

	private static void watch(Node cctv, int dir) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		
		queue.offer(cctv);
		visit[cctv.y][cctv.x] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int nx = now.x + dx[dir];
			int ny = now.y + dy[dir];
			
			if(nx < 0 || ny < 0 || nx >= M || ny >= N || copy[ny][nx] == 6) {
				break;
			}
			
			if(copy[ny][nx] == 0) {
				copy[ny][nx] = -1;
				queue.offer(new Node(cctv.cctvKind, nx, ny));
			}else {
				queue.offer(new Node(cctv.cctvKind, nx, ny));
			}
		}
	}

}
