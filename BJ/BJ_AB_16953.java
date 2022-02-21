package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_AB_16953 {
	static long A, B;

	static class Node {
		long num;
		int cnt;

		public Node(long num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		bfs(A, B);
	}

	private static void bfs(long num, long target) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(num, 0));

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.num == target) {
				System.out.println(node.cnt + 1);
				return;
			}
			for (int i = 0; i < 2; i++) {
				long x = 0;
				if (i == 0) {
					x = node.num * 2;
				} else {
					x = node.num * 10 + 1;
				}
				if (x <= target) {
					q.offer(new Node(x, node.cnt + 1));
				}
			}
		}
		System.out.println(-1);
	}

}
