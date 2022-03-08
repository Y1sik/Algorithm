package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_트리의순회 {
	static int n;
	static int[] inorder;
	static int[] postorder;
	static int[] preorder;
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		inorder = new int[n];
		postorder = new int[n];
		preorder = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}

		GetPreOrder(0, n - 1, 0, n - 1);
		for (int n : preorder) {
			System.out.print(n + " ");
		}
	}

	private static void GetPreOrder(int is, int ie, int ps, int pe) {
		if(is <= ie && ps <= pe) {
			preorder[idx++] = postorder[pe];
			
			int pos = is;
			for (int i = is; i <= ie; i++) {
				if(inorder[i] == postorder[pe]) {
					pos = i;
					break;
				}
			}
			
			GetPreOrder(is, pos - 1, ps, ps + pos - is - 1);
			GetPreOrder(pos + 1, ie, ps + pos - is, pe - 1);
		}

	}

}
