package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_·Îº¿Ã»¼Ò±â {
	static int N, M;
	static int r, c, d;
	static int[][] map;
	static boolean[][] visit;
	static int cnt = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit[r][c] = true;
		dfs(r, c, d);
		System.out.println(cnt);
	}

	private static void dfs(int y, int x, int d) {
		int nx = 0;
		int ny = 0;
		boolean check = false;
		for (int i = 0; i < 4; i++) {
			if(d == 0) {
				nx = x - 1;
				ny = y;
				d = 3;
			}else if(d == 1) {
				nx = x;
				ny = y - 1;
				d = 0;
			}else if(d == 2) {
				nx = x + 1;
				ny = y;
				d = 1;
			}else if(d == 3) {
				nx = x;
				ny = y + 1;
				d = 2;
			}
			
			if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visit[ny][nx] && map[ny][nx] == 0) {
				cnt++;
				visit[ny][nx] = true;
				dfs(ny, nx, d);
				check = true;
				break;
			}
		}
		
		if(!check) {
			if(d == 0) {
				nx = x;
				ny = y + 1;
			}else if(d == 1) {
				nx = x - 1;
				ny = y;
			}else if(d == 2) {
				nx = x;
				ny = y - 1;
			}else if(d == 3) {
				nx = x + 1;
				ny = y;
			}
			
			if(map[ny][nx] != 1) {
				dfs(ny, nx, d);
			}
		}
		
		
	}

}
