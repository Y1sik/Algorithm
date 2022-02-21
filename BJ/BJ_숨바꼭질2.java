package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_¼û¹Ù²ÀÁú2 {
	static int N, K;
	static boolean[] visit;
	static int result = Integer.MAX_VALUE;
	static int ans = 1;
	
	static class Node {
		int position;
		int cnt;

		public Node(int position, int cnt) {
			super();
			this.position = position;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new boolean[100001];

		System.out.println(BFS(N, K));
		System.out.println(ans);
	}

	private static int BFS(int n, int k) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(n, 0));
		visit[n] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			int pos = node.position;
			int cnt = node.cnt;
			visit[pos] = true;

			if (pos == k) {
				if(result > cnt) {
					result = cnt;
				}else if(result == cnt) {
					ans++;
				}
				continue;
			}
			if (pos + 1 < 100001 && visit[pos + 1] == false) {
				q.offer(new Node(pos + 1, cnt + 1));
			}
			if (pos - 1 >= 0 && visit[pos - 1] == false) {
				q.offer(new Node(pos - 1, cnt + 1));
			}
			if (pos * 2 < 100001 && visit[pos * 2] == false) {
				q.offer(new Node(pos * 2, cnt + 1));
			}

		}
		return result;
	}

}
