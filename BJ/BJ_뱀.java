package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_¹ì {
	static int N;
	static int K;
	static int r, c;
	static int L;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static List<int[]> snake;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];

		snake = new LinkedList<int[]>();
		snake.add(new int[] { 1, 1 });

		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}

		L = Integer.parseInt(br.readLine());
		Map<Integer, String> dir = new HashMap<>();
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			dir.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		int time = dfs(1, 1, 0, dir);
		System.out.println(time);
	}

	private static int dfs(int y, int x, int nowDir, Map<Integer, String> dir) {
		int time = 0;
		while(true) {
			time++;
			int nx = x + dx[nowDir];
			int ny = y + dy[nowDir];
			
			if(nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1) {
				break;
			}
			
			for (int i = 0; i < snake.size(); i++) {
				
				if(nx == snake.get(i)[1] && ny == snake.get(i)[0]) {
					return time;
				}
			}
			
			if(map[ny][nx] == 1) {
				map[ny][nx] = 0;
				snake.add(new int[] {ny, nx});
			}else {
				snake.add(new int[] {ny, nx});
				snake.remove(0);
			}
			
			x = nx;
			y = ny;
			
			if(dir.containsKey(time)) {
				if(dir.get(time).equals("D")) {
					nowDir++;
					if(nowDir == 4) {
						nowDir = 0;
					}
				}
				else if(dir.get(time).equals("L")) {
					nowDir--;
					if(nowDir == -1) {
						nowDir = 3;
					}
				}
			}
		}
		return time;
	}

	

}
