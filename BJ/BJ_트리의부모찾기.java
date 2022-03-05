package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_트리의부모찾기 {
	static int N;
	static ArrayList<Integer>[] arr;
	static int[] parents;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		parents = new int[N + 1];
		visit = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		dfs(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}

	private static void dfs(int i) {
		if(visit[i]) {
			return;
		}
		
		visit[i] = true;
		for (int j : arr[i]) {
			if(!visit[j]) {
				parents[j] = i;
				dfs(j);
			}
		}
		
	}

}
