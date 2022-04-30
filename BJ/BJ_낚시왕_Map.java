package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_³¬½Ã¿Õ_Map {
	
	static int R, C, M;
	static int r, c, s, d, z;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 }; // »ó ÁÂ ÇÏ ¿ì
	static Node[][] map;
	static int result;

	static class Node {
		int r;
		int c;
		int s; // ¼Óµµ
		int d; // ¹æÇâ
		int z; // Å©±â

		public Node(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Node[R][C];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			if(d == 1) { // »ó ÇÏ ¿ì ÁÂ  -> »ó ÁÂ ÇÏ ¿ì
				d = 0;
			}else if(d == 4) {
				d = 1;
			}
			map[r][c] = new Node(r, c, s, d, z);
		}
		
		move();
		System.out.println(result);

	}

	private static void move() {
		for (int i = 0; i < C; i++) {
			fishing(i);
			sharkMove();
		}
		
	}

	private static void sharkMove() {
		Queue<Node> shark = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != null) {
					shark.offer(map[i][j]);
				}
			}
		}
		
		map = new Node[R][C];
		
		while(!shark.isEmpty()) {
			Node now = shark.poll();
			
			int speed = now.s;
			if(now.d == 0 || now.d == 2) { // »ó ÇÏ
				speed %= (R - 1) * 2;
			}else if(now.d == 1 || now.d == 3) { // ÁÂ ¿ì
				speed %= (C - 1) * 2;
			}
			
			for (int i = 0; i < speed; i++) {
				int nx = now.c + dx[now.d];
				int ny = now.r + dy[now.d];
				
				if(nx < 0 || ny < 0 || nx >= C || ny >= R) {
					now.c -= dx[now.d];
					now.r -= dy[now.d];
					now.d = (now.d + 2) % 4;
					continue;
				}
				
				now.c = nx;
				now.r = ny;
			}
			
			if(map[now.r][now.c] != null) {
				if(map[now.r][now.c].z < now.z) {
					map[now.r][now.c] = now;
				}
			} else {
				map[now.r][now.c] = now;
			}
		}
		
	}

	private static void fishing(int col) {
		for (int i = 0; i < R ; i++) {
			if(map[i][col] != null) {
				result += map[i][col].z;
				map[i][col] = null;
				break;
			}
		}
	}

}
