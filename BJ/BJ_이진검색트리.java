package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_이진검색트리 {
	static class Node {
		int num;
		Node left, right;
		
		public Node(int num) {
			super();
			this.num = num;
		}
		
		public void Insert(int num) {
			if(this.num > num) {
				if(this.left == null) {
					this.left = new Node(num);
				}
				else {
					this.left.Insert(num);
				}
			} else {
				if(this.right == null) {
					this.right = new Node(num);
				}
				else {
					this.right.Insert(num);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		while(true) {
			String n = br.readLine(); 
			if(n==null||n.equals("")) break;
			root.Insert(Integer.parseInt(n));
		}
		
		postOrder(root);
	}
	
	private static void postOrder(Node node) {
		if(node == null) {
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
		
	}

}
