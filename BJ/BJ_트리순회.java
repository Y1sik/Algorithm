package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_트리순회 {
	static int N;
	static class Node {
		char data;
		Node left, right;
		public Node(char data) {
			this.data = data;
		}
	}
	static class Tree {
		Node root;
		public void Add(char data, char left_data, char right_data) {
			if(root == null) {
				if(data != '.') root = new Node(data);
				if(left_data != '.') root.left = new Node(left_data);
				if(right_data != '.') root.right = new Node(right_data);
			}
			else {
				Search(root, data, left_data, right_data);
			}
		}
		
		private void Search(Node root, char data, char left_data, char right_data) {
			if(root == null) return;
			
			else if(root.data == data) {
				if(left_data != '.') root.left = new Node(left_data);
				if(right_data != '.') root.right = new Node(right_data);
			}
			
			else {
				Search(root.left, data, left_data, right_data);
				Search(root.right, data, left_data, right_data);
			}
			
		}
		
		public void PreOrder(Node root) {
			System.out.print(root.data);
			if(root.left != null) PreOrder(root.left);
			if(root.right != null) PreOrder(root.right);
		}
		
		public void InOrder(Node root) {
			if(root.left != null) InOrder(root.left);
			System.out.print(root.data);
			if(root.right != null) InOrder(root.right);
		}
		
		public void PostOrder(Node root) {
			if(root.left != null) PostOrder(root.left);
			if(root.right != null) PostOrder(root.right);
			System.out.print(root.data);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Tree tree = new Tree();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char root_data = st.nextToken().charAt(0);
			char left_data = st.nextToken().charAt(0);
			char right_data = st.nextToken().charAt(0);
			tree.Add(root_data, left_data, right_data);
		}
		tree.PreOrder(tree.root);
		System.out.println();
		tree.InOrder(tree.root);
		System.out.println();
		tree.PostOrder(tree.root);
	}

}
