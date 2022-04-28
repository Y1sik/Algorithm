package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_��������ũ {
	static int N, M, K;
	static int map[][];
	static int add[][];
	static Queue<Tree> trees;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 }; // �� �»� �� ��� �� ���� �� ����
	static int result;

	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;

		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		add = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				add[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		trees = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			trees.add(new Tree(x, y, age));
		}
		
		Collections.sort((List<Tree>) trees); // ���̼����� ����

		System.out.println(finance());
	}

	private static int finance() {
		while(K-- > 0) {
			spring();
			fall();
			winter();
		}

		return trees.size();
	}

	private static void spring() {
		ArrayList<Tree> die = new ArrayList<>();
		
		int size = trees.size();
		for (int i = 0; i < size; i++) {
			Tree now = trees.poll();
			if (map[now.x][now.y] - now.age < 0) {
				die.add(new Tree(now.x, now.y, now.age / 2)); // ���� ���� ����Ʈ�� �߰�
			}else { // ����� ������ ���̺��� ũ�ų� ���� ���
				map[now.x][now.y] -= now.age; // ����� ������ ���̸�ŭ ����
				trees.add(new Tree(now.x, now.y, now.age + 1));
			} 
		}
		for (Tree t : die) {
			map[t.x][t.y] += t.age; 
		}
	}

	private static void fall() {
		
		ArrayList<Tree> parents = new ArrayList<>();
		int size = trees.size();
		while (size-- > 0) {
			Tree now = trees.poll();
			if(now.age % 5 == 0) { // ������ ���̰� 5�� ����� �ƴ� ��� ���� ����
				for (int j = 0; j < 8; j++) {
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // map�� ũ�⸦ ����� ���� ����
					
					trees.add(new Tree(nx, ny, 1)); // ������ ������
				}
			}
			parents.add(now);
		}
		
		for (Tree t : parents) {
			trees.add(t);
		}
	}

	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += add[i][j]; // ��� �߰�
			}
		}

	}

}
