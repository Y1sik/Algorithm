package BJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_�����̾Ʈ���Ƿκ�_linkedlist {
	static int N, K;
	static LinkedList<Node> belt;
	static int index;
	static int check;

	static class Node {
		int durability;
		boolean robot;

		public Node(int durability, boolean robot) {
			super();
			this.durability = durability;
			this.robot = robot;
		}		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new LinkedList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 2 * N; i++) {
			int a = Integer.parseInt(st.nextToken());
			belt.add(new Node(a, false));
		}
		bw.write(conveyor_belt() + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static int conveyor_belt() {
		while(isOk()) {
			rotate(); // ��Ʈ ȸ��
			move(); // �κ��� ������
			add_robot(); // �κ� �ø�
			index++;
		}
		
		return index;
	}

	private static boolean isOk() { // ������ 0 ���� üũ
		check = 0;
		for (int i = 0; i < belt.size(); i++) {
			if(belt.get(i).durability == 0) {
				check++;
			}
		}
		
		if(check >= K) {
			return false;
		}
		return true;
	}

	private static void move() {
//		Node node;
		for (int i = N - 1; i > 0; i--) { // n-1 ��ġ���� �κ��� ��������. ���� ��Ʈ���� �ö� �κ��� N - 1 ���� ã���� �� ���� ���� ���� �κ��̴�.
			if(belt.get(i - 1).robot && belt.get(i).durability > 0 && !belt.get(i).robot) {
//				node = new Node(belt.get(i).durability - 1, true);
				belt.set(i, new Node(belt.get(i).durability - 1, true)); // �κ��� ������
				
//				node = new Node(belt.get(i - 1).durability, false);
				belt.set(i - 1, new Node(belt.get(i - 1).durability, false)); // �κ��� ������ �ִ� �� ����
				
			}
		}
		if(belt.get(N - 1).robot) { // �κ� ������
//			node = new Node(belt.get(N - 1).durability, false);
			belt.set(N - 1, new Node(belt.get(N - 1).durability, false));
		}
	}

	private static void add_robot() {
		if (belt.get(0).durability > 0) { // �κ� �߰�
			belt.set(0, new Node(belt.get(0).durability - 1, true));
		}
	}

	private static void rotate() {
		Node node;
		
		node = belt.pollLast(); // ��Ʈ�� ������ ����
		belt.addFirst(node); // ��Ʈ�� ù��° ������ ������ ��
		
		if(belt.get(N - 1).robot) { // �κ� ������
//			node = new Node(belt.get(N - 1).durability, false);
			belt.set(N - 1, new Node(belt.get(N - 1).durability, false));
		}
		
	}

}
