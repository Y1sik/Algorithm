package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070 {
	static int N;
	static int[][] map;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Pipe(0,1,0);
		
		System.out.println(count);

	}

	private static void Pipe(int y, int x, int dir) {
		if(x == N-1 && y == N-1) {
			count++;
			return;
		}
		
		if(dir == 0) {
			if(isRange(y, x + 1) && map[y][x + 1] != 1) {
				Pipe(y, x + 1, 0);
			} 
			if(isRange(y + 1, x + 1) && map[y][x + 1] != 1 && map[y + 1][x + 1] != 1 && map[y + 1][x] != 1) {
				Pipe(y + 1, x + 1, 2);
			}
		}
		else if(dir == 1) {
			if(isRange(y + 1, x) && map[y + 1][x] != 1) {
				Pipe(y + 1, x, 1);
			}
			if(isRange(y + 1, x + 1) && map[y][x + 1] != 1 && map[y + 1][x + 1] != 1 && map[y + 1][x] != 1) {
				Pipe(y + 1, x + 1, 2);
			}
		}
		else if(dir == 2) {
			if(isRange(y + 1, x) && map[y + 1][x] != 1) {
				Pipe(y + 1, x, 1);
			}
			if(isRange(y + 1, x + 1) && map[y][x + 1] != 1 && map[y + 1][x + 1] != 1 && map[y + 1][x] != 1) {
				Pipe(y + 1, x + 1, 2);
			}
			if(isRange(y, x + 1) && map[y][x + 1] != 1) {
				Pipe(y, x + 1, 0);
			}
		}
		
	}

	private static boolean isRange(int y, int x) {
		if(y < 0 || x < 0 || y >= N || x >= N) {
			return false;
		}
		return true;
	}

}
