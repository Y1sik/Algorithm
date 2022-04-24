package BJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_컨베이어벨트위의로봇_linkedlist {
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
			rotate(); // 벨트 회전
			move(); // 로봇이 움직임
			add_robot(); // 로봇 올림
			index++;
		}
		
		return index;
	}

	private static boolean isOk() { // 내구도 0 개수 체크
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
		for (int i = N - 1; i > 0; i--) { // n-1 위치에서 로봇은 내려진다. 먼저 벨트위에 올라간 로봇은 N - 1 부터 찾았을 때 가장 먼저 나온 로봇이다.
			if(belt.get(i - 1).robot && belt.get(i).durability > 0 && !belt.get(i).robot) {
//				node = new Node(belt.get(i).durability - 1, true);
				belt.set(i, new Node(belt.get(i).durability - 1, true)); // 로봇이 움직임
				
//				node = new Node(belt.get(i - 1).durability, false);
				belt.set(i - 1, new Node(belt.get(i - 1).durability, false)); // 로봇이 이전에 있던 곳 수정
				
			}
		}
		if(belt.get(N - 1).robot) { // 로봇 내리기
//			node = new Node(belt.get(N - 1).durability, false);
			belt.set(N - 1, new Node(belt.get(N - 1).durability, false));
		}
	}

	private static void add_robot() {
		if (belt.get(0).durability > 0) { // 로봇 추가
			belt.set(0, new Node(belt.get(0).durability - 1, true));
		}
	}

	private static void rotate() {
		Node node;
		
		node = belt.pollLast(); // 벨트의 마지막 값을
		belt.addFirst(node); // 벨트의 첫번째 값으로 가지고 옴
		
		if(belt.get(N - 1).robot) { // 로봇 내리기
//			node = new Node(belt.get(N - 1).durability, false);
			belt.set(N - 1, new Node(belt.get(N - 1).durability, false));
		}
		
	}

}
