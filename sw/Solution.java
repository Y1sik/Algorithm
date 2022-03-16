package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static int[] map;
	static ArrayList<Node> gate;
	static int result = Integer.MAX_VALUE;
	static int[] dx = { 1, -1 };

	static class Node {
		int g_num;
		int p_num;

		public Node(int g_num, int p_num) {
			super();
			this.g_num = g_num;
			this.p_num = p_num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			gate = new ArrayList<Node>();

			for (int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int g_num = Integer.parseInt(st.nextToken());
				int p_num = Integer.parseInt(st.nextToken());
				gate.add(new Node(g_num, p_num));
			}

			// 1 2 3, 1 3 2, 2 1 3, 2 3 1, 3 1 2, 3 2 1
			result = Math.min(result, Fishing(0, 1, 2));
			result = Math.min(result, Fishing(0, 2, 1));
			result = Math.min(result, Fishing(1, 0, 2));
			result = Math.min(result, Fishing(1, 2, 0));
			result = Math.min(result, Fishing(2, 1, 0));
			result = Math.min(result, Fishing(2, 0, 1));

			System.out.println("#" + t + " " +result);
			result = Integer.MAX_VALUE;
		}

	}

//	private static int Fishing(int f, int s, int t) {
//		int ans = 0;
//		map = new int[N + 1];
//		
//		for (int i = 0; i < 3; i++) {
//			int cnt = 1;
//			Node node;
//			if(i == 0) {
//				node = gate.get(f);
//			}else if(i == 1) {
//				node = gate.get(s);
//			}else {
//				node = gate.get(t);
//			}
//			
//			int g = node.g_num;
//			int p = node.p_num;
//			if(map[g] == 0) {
//				map[g] = cnt++;
//				p--;
//			}else {
//				cnt++;
//			}
//			while(p != 0) {
//				for (int j = 0; j < 2; j++) {
//					int ng = dx[j] + g;
//					if(ng <= 0 || ng > N) continue;
//					if(map[ng] != 0) continue;
//					map[ng] = cnt;
//					p--;
//					if(p == 0) break;
//				}
//				dx[0] += 1;
//				dx[1] += -1;
//				cnt++;
//			}
//			dx[0] = 1;
//			dx[1] = -1;
//		}
//		
//		for (int i = 0; i < map.length; i++) {
////			ans += map[i];
//			System.out.print(map[i] + " ");
//		}
//		System.out.println();
//		
//		
//		return ans;
//	}

	private static int Fishing(int f, int s, int t) {
		int ans = 0;
		map = new int[N + 1];

		for (int i = 0; i < 3; i++) {
			Node node;
			if (i == 0) {
				node = gate.get(f);
			} else if (i == 1) {
				node = gate.get(s);
			} else {
				node = gate.get(t);
			}

			int g = node.g_num;
			int p = node.p_num;
			int cnt = 1;
			
			
			if(map[g] == 0) {
				map[g] = cnt++;
				p--;
			}
			else if(map[g] != 0) cnt++;
			Solve(g, p, cnt);
		}

		for (int i = 1; i < map.length; i++) {
			ans += map[i];
			System.out.print(map[i] + " ");
		}
		System.out.println();

		return ans;
	}

	private static void Solve(int gi, int pn, int cnt) {
		int gg = gi;
		
		if(pn == 0) {
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			int ng = gg + dx[i];
			if(ng <= 0 || ng > N) continue;
			if(map[ng] == 0) {
				map[ng] = cnt;
				Solve(ng, pn-1, cnt+1);
			}
		}
	}

}