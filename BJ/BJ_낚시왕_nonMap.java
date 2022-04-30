package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_낚시왕_nonMap {
	static int R, C, M;
	static int r, c, s, d, z;
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, -1, 1, 0, 0 }; // 상 하 우 좌
	static ArrayList<Node> shark;
	static int result;

	static class Node {
		int r;
		int c;
		int s; // 속도
		int d; // 방향
		int z; // 크기

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

		shark = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			shark.add(new Node(r, c, s, d, z));
		}

		move();
		
		System.out.println(result);
	}

	private static void move() {
		for (int i = 1; i <= C; i++) { // 낚시왕은 열의 마지막 칸에 도착하면 움직임을 멈춘다.
//			System.out.println(i + "초");
			fishing(i);
			sharkMove();
		}

	}

	private static void fishing(int c) {
		int min = Integer.MAX_VALUE; // 땅과 가장 가까운 상어의 행 값
		int sharkIdx = -1; // 상어 인덱스
		for (int j = 0; j < shark.size(); j++) {
			if (shark.get(j).c == c) {
				if(min > shark.get(j).r) {
					sharkIdx = j;
					min = shark.get(j).r;
				}
			}
		}
		
		if(sharkIdx != -1) {
//			System.out.println("상어 잡음 " + shark.get(sharkIdx));
			result += shark.get(sharkIdx).z;
			shark.remove(sharkIdx);
		}
	}
	
	private static void sharkMove() {
		for (int i = 0; i < shark.size(); i++) {
			Node now = shark.get(i);
			int xx = now.c;
			int yy = now.r;
			
			if(now.d == 1 || now.d == 2) { // 상하
//				System.out.println(now.s);
				for (int j = 0; j < now.s; j++) {
					int nx = xx + dx[now.d];
					int ny = yy + dy[now.d];
					
					if(nx < 1 || ny < 1) { // 범위를 벗어나면 방향을 반대로 바꾼다. 위로 벗어나면 하
						now.d = 2;
						nx = xx + dx[now.d];
						ny = yy + dy[now.d];
					}else if (nx > C || ny > R) { // 아래로 벗어나면 상
						now.d = 1;
						nx = xx + dx[now.d];
						ny = yy + dy[now.d];
					}
					
					xx = nx;
					yy = ny;
//					System.out.println(yy + " " + xx);
				}
				
				shark.set(i, new Node(yy, xx, now.s, now.d, now.z)); // 상어의 위치를 변경해준다.
				
			}else if (now.d == 3 || now.d == 4){ // 좌우
//				System.out.println(now.s);
				for (int j = 0; j < now.s; j++) {
					int nx = xx + dx[now.d];
					int ny = yy + dy[now.d];
					
					if(nx < 1 || ny < 1) { // 범위를 벗어나면 방향을 반대로 바꾼다. 좌로 벗어나면 우
						now.d = 3;
						nx = xx + dx[now.d];
						ny = yy + dy[now.d];
					}else if (nx > C || ny > R) { // 우로 벗어나면 좌
						now.d = 4;
						nx = xx + dx[now.d];
						ny = yy + dy[now.d];
					}
					
					xx = nx;
					yy = ny;
//					System.out.println(yy + " " + xx);
				}
				
				shark.set(i, new Node(yy, xx, now.s, now.d, now.z)); // 상어의 위치를 변경해준다.
			}
			
			sharkEat(i);
		}
	}
	
	private static void sharkEat(int index) {
		Node now = shark.get(index);
		ArrayList<Integer> die = new ArrayList<>();
		for (int i = 0; i < index; i++) { // 비교해야하는 상어의 순서까지만 돌림 
			if(now.r == shark.get(i).r && now.c == shark.get(i).c) { // r, c의 값이 같으면 한칸에 상어가 2마리 이상임
				if(now.z > shark.get(i).z) { // 크기가 큰 상어가 잡아 먹는다.
					die.add(i);
				}else {
					die.add(index);
				}
			}
		}
		
		for (int i = 0; i < die.size(); i++) {
//			System.out.println("상어 먹음 " + shark.get(die.get(i)));
			shark.set(die.get(i), new Node(0,0,0,0,0));
//			shark.remove(die.get(i));
		}
		
	}

}
