package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	static int[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int result = Integer.MAX_VALUE;
	
	static class Node {
		int y;
		int x;
		int dis;
		int break_wall;
		public Node(int y, int x, int dis, int break_wall) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.break_wall = break_wall;
		}
		
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		
		System.out.println(bfs(0, 0));
	}

	private static int bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(y, x, 1, 0));
		visit[y][x] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int xx = node.x;
			int yy = node.y;
			
			if(xx == M - 1 && yy == N - 1) {
				return node.dis;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = xx + dx[i];
				int ny = yy + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if(visit[ny][nx] <= node.break_wall) continue;
				if(map[ny][nx] == 0) {
					queue.offer(new Node(ny, nx, node.dis+1, node.break_wall));
					visit[ny][nx] = node.break_wall;
				}else {
					if(node.break_wall == 0) {
						queue.offer(new Node(ny, nx, node.dis+1, node.break_wall+1));
						visit[ny][nx] = node.break_wall + 1;
					}
					
				}
			}
		}
		return -1;
	}

	

}
