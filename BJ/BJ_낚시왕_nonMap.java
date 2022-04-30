package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_���ÿ�_nonMap {
	static int R, C, M;
	static int r, c, s, d, z;
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, -1, 1, 0, 0 }; // �� �� �� ��
	static ArrayList<Node> shark;
	static int result;

	static class Node {
		int r;
		int c;
		int s; // �ӵ�
		int d; // ����
		int z; // ũ��

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
		for (int i = 1; i <= C; i++) { // ���ÿ��� ���� ������ ĭ�� �����ϸ� �������� �����.
//			System.out.println(i + "��");
			fishing(i);
			sharkMove();
		}

	}

	private static void fishing(int c) {
		int min = Integer.MAX_VALUE; // ���� ���� ����� ����� �� ��
		int sharkIdx = -1; // ��� �ε���
		for (int j = 0; j < shark.size(); j++) {
			if (shark.get(j).c == c) {
				if(min > shark.get(j).r) {
					sharkIdx = j;
					min = shark.get(j).r;
				}
			}
		}
		
		if(sharkIdx != -1) {
//			System.out.println("��� ���� " + shark.get(sharkIdx));
			result += shark.get(sharkIdx).z;
			shark.remove(sharkIdx);
		}
	}
	
	private static void sharkMove() {
		for (int i = 0; i < shark.size(); i++) {
			Node now = shark.get(i);
			int xx = now.c;
			int yy = now.r;
			
			if(now.d == 1 || now.d == 2) { // ����
//				System.out.println(now.s);
				for (int j = 0; j < now.s; j++) {
					int nx = xx + dx[now.d];
					int ny = yy + dy[now.d];
					
					if(nx < 1 || ny < 1) { // ������ ����� ������ �ݴ�� �ٲ۴�. ���� ����� ��
						now.d = 2;
						nx = xx + dx[now.d];
						ny = yy + dy[now.d];
					}else if (nx > C || ny > R) { // �Ʒ��� ����� ��
						now.d = 1;
						nx = xx + dx[now.d];
						ny = yy + dy[now.d];
					}
					
					xx = nx;
					yy = ny;
//					System.out.println(yy + " " + xx);
				}
				
				shark.set(i, new Node(yy, xx, now.s, now.d, now.z)); // ����� ��ġ�� �������ش�.
				
			}else if (now.d == 3 || now.d == 4){ // �¿�
//				System.out.println(now.s);
				for (int j = 0; j < now.s; j++) {
					int nx = xx + dx[now.d];
					int ny = yy + dy[now.d];
					
					if(nx < 1 || ny < 1) { // ������ ����� ������ �ݴ�� �ٲ۴�. �·� ����� ��
						now.d = 3;
						nx = xx + dx[now.d];
						ny = yy + dy[now.d];
					}else if (nx > C || ny > R) { // ��� ����� ��
						now.d = 4;
						nx = xx + dx[now.d];
						ny = yy + dy[now.d];
					}
					
					xx = nx;
					yy = ny;
//					System.out.println(yy + " " + xx);
				}
				
				shark.set(i, new Node(yy, xx, now.s, now.d, now.z)); // ����� ��ġ�� �������ش�.
			}
			
			sharkEat(i);
		}
	}
	
	private static void sharkEat(int index) {
		Node now = shark.get(index);
		ArrayList<Integer> die = new ArrayList<>();
		for (int i = 0; i < index; i++) { // ���ؾ��ϴ� ����� ���������� ���� 
			if(now.r == shark.get(i).r && now.c == shark.get(i).c) { // r, c�� ���� ������ ��ĭ�� �� 2���� �̻���
				if(now.z > shark.get(i).z) { // ũ�Ⱑ ū �� ��� �Դ´�.
					die.add(i);
				}else {
					die.add(index);
				}
			}
		}
		
		for (int i = 0; i < die.size(); i++) {
//			System.out.println("��� ���� " + shark.get(die.get(i)));
			shark.set(die.get(i), new Node(0,0,0,0,0));
//			shark.remove(die.get(i));
		}
		
	}

}
