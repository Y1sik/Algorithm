package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Æ®¸® {
	static int N;
	static int[] parents;
	static boolean[] visit;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		parents = new int[N];
		visit = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int root = 0;
		for (int i = 0; i < N; i++) {
			parents[i] = Integer.parseInt(st.nextToken());
			if(parents[i] == -1) {
				root = i;
			}
		}
		
		int delNode = Integer.parseInt(br.readLine());
		
		Delete_Node(delNode);
		
		FindLeaf(root);
		
		System.out.println(result);

	}

	private static void FindLeaf(int parent) {
		boolean leaf = true;
		visit[parent] = true;
		
		if(parents[parent] != -2) {
			for (int i = 0; i < N; i++) {
				if(parents[i] == parent && !visit[i]) {
					FindLeaf(i);
					leaf = false;
				}
			}
			if(leaf) result++;
		}
		
		
	}

	private static void Delete_Node(int d) {
		parents[d] = -2;
		for (int i = 0; i < N; i++) {
			if(parents[i] == d) {
				parents[i] = -2;
				Delete_Node(i);
			}
		}
		
	}

}
